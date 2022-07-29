package util;

public interface IVault<T, K> {

  /**
   * Armazena um objeto com uma senha, ambos não nulos.
   *
   * @param object   um objeto não nulo.
   * @param password uma senha não nula.
   *
   * @throws NullPointerException  se objeto ou senha forem nulos.
   * @throws WeakPasswordException se a senha não for forte.
   */
  void store(T object, K password, IPasswordConstraints<K> constraints);

  /**
   * Recupera o objeto armazenado se a senha estiver correta.
   *
   * @param password uma senha não nula.
   * @return o objeto armazenado se a senha estiver correta.
   * @throws WrongPasswordException se a senha estiver incorreta.
   */
  T retrieve(K password);

  class WrongPasswordException extends Exception {
  }

  class WeakPasswordException extends Exception {
  }

  /**
   * Especifica os requisitos para considerar uma senha forte.
   *
   */
  @FunctionalInterface
  interface IPasswordConstraints<K> {
    /**
     * Avalia a força da senha.
     *
     * @param password a senha a ser avaliada.
     * @return `true` se a senha for forte e `false` caso contrário.
     * @throws NullPointerException se a senha for null.
     */
    boolean isStrong(K password);
  }
}
