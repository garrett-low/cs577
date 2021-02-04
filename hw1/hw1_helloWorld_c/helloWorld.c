#define _GNU_SOURCE
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char const *argv[])
{
  int instances;
  
  scanf("%i", &instances);
  getchar();
  
  for (int i = 0; i < instances; i++)
  {
    char *input = NULL;
    size_t len;
    ssize_t nread;
    while ((nread = getline(&input, &len, stdin))) {
    }
    
    input[nread] = '\0';
    printf("Hello, %s!", input);
  }
  
  return 0;
}
