module.exports = {
  env: {
    browser: true,
    es6: true,
    node: true
  },
  extends: [
    'plugin:@typescript-eslint/eslint-recommended',
    'plugin:prettier/recommended',
    'prettier/@typescript-eslint'
  ],
  parser: '@typescript-eslint/parser',
  parserOptions: {
    ecmaVersion: 6,
    project: 'tsconfig.json',
    sourceType: 'module',
    ecmaFeatures: {
      modules: true
    }
  },
  plugins: ['prettier', '@typescript-eslint'],
  rules: {}
};
