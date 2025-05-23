type Props = {
 texto: string;
};
export default function Titulo({ texto }: Props) {
 return <h2>{texto}</h2>
}
