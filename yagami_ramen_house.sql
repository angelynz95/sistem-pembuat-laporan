-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 13 Apr 2016 pada 17.54
-- Versi Server: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `yagami_ramen_house`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `akun`
--

CREATE TABLE IF NOT EXISTS `akun` (
  `password` varchar(200) NOT NULL,
  PRIMARY KEY (`password`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `akun`
--

INSERT INTO `akun` (`password`) VALUES
('yagamiramenhouse');

-- --------------------------------------------------------

--
-- Struktur dari tabel `dessert`
--

CREATE TABLE IF NOT EXISTS `dessert` (
  `id_dessert` int(11) NOT NULL AUTO_INCREMENT,
  `nama_dessert` varchar(200) NOT NULL,
  `harga_dessert` int(11) NOT NULL,
  PRIMARY KEY (`id_dessert`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data untuk tabel `dessert`
--

INSERT INTO `dessert` (`id_dessert`, `nama_dessert`, `harga_dessert`) VALUES
(1, 'Ice Cream Green Tea', 10000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `list_dessert`
--

CREATE TABLE IF NOT EXISTS `list_dessert` (
  `id_dessert` int(11) NOT NULL,
  `jumlah_dessert` int(11) NOT NULL,
  `id_order` int(11) NOT NULL,
  KEY `id_dessert` (`id_dessert`),
  KEY `id_order` (`id_order`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `list_dessert`
--

INSERT INTO `list_dessert` (`id_dessert`, `jumlah_dessert`, `id_order`) VALUES
(1, 3, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `list_minuman`
--

CREATE TABLE IF NOT EXISTS `list_minuman` (
  `id_minuman` int(11) NOT NULL,
  `jumlah_minuman` int(11) NOT NULL,
  `id_order` int(11) NOT NULL,
  KEY `id_minuman` (`id_minuman`),
  KEY `id_order` (`id_order`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `list_minuman`
--

INSERT INTO `list_minuman` (`id_minuman`, `jumlah_minuman`, `id_order`) VALUES
(1, 3, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `list_nasi`
--

CREATE TABLE IF NOT EXISTS `list_nasi` (
  `id_nasi` int(11) NOT NULL,
  `jumlah_nasi` int(11) NOT NULL,
  `id_order` int(11) NOT NULL,
  KEY `id_nasi` (`id_nasi`),
  KEY `id_order` (`id_order`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `list_nasi`
--

INSERT INTO `list_nasi` (`id_nasi`, `jumlah_nasi`, `id_order`) VALUES
(1, 2, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `list_ramen`
--

CREATE TABLE IF NOT EXISTS `list_ramen` (
  `id_ramen` int(11) NOT NULL,
  `jumlah_ramen` int(11) NOT NULL,
  `id_order` int(11) NOT NULL,
  KEY `id_ramen` (`id_ramen`),
  KEY `id_order` (`id_order`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `list_ramen`
--

INSERT INTO `list_ramen` (`id_ramen`, `jumlah_ramen`, `id_order`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `list_snack`
--

CREATE TABLE IF NOT EXISTS `list_snack` (
  `id_snack` int(11) NOT NULL,
  `jumlah_snack` int(11) NOT NULL,
  `id_order` int(11) NOT NULL,
  KEY `id_snack` (`id_snack`),
  KEY `id_order` (`id_order`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `list_snack`
--

INSERT INTO `list_snack` (`id_snack`, `jumlah_snack`, `id_order`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `list_topping`
--

CREATE TABLE IF NOT EXISTS `list_topping` (
  `id_topping` int(11) NOT NULL,
  `jumlah_topping` int(11) NOT NULL,
  `id_order` int(11) NOT NULL,
  KEY `id_topping` (`id_topping`),
  KEY `id_order` (`id_order`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `list_topping`
--

INSERT INTO `list_topping` (`id_topping`, `jumlah_topping`, `id_order`) VALUES
(1, 3, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `minuman`
--

CREATE TABLE IF NOT EXISTS `minuman` (
  `id_minuman` int(11) NOT NULL AUTO_INCREMENT,
  `nama_minuman` varchar(200) NOT NULL,
  `harga_minuman` int(11) NOT NULL,
  PRIMARY KEY (`id_minuman`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data untuk tabel `minuman`
--

INSERT INTO `minuman` (`id_minuman`, `nama_minuman`, `harga_minuman`) VALUES
(1, 'Teh Tarik', 7000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `nasi`
--

CREATE TABLE IF NOT EXISTS `nasi` (
  `id_nasi` int(11) NOT NULL AUTO_INCREMENT,
  `nama_nasi` varchar(200) NOT NULL,
  `harga_nasi` int(11) NOT NULL,
  PRIMARY KEY (`id_nasi`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data untuk tabel `nasi`
--

INSERT INTO `nasi` (`id_nasi`, `nama_nasi`, `harga_nasi`) VALUES
(1, 'Nasi Putih', 5000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `order`
--

CREATE TABLE IF NOT EXISTS `order` (
  `id_order` int(11) NOT NULL AUTO_INCREMENT,
  `nama_tamu` varchar(200) NOT NULL,
  `jumlah_tamu` int(11) NOT NULL,
  `waktu` date NOT NULL,
  `potongan` bigint(20) NOT NULL,
  PRIMARY KEY (`id_order`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data untuk tabel `order`
--

INSERT INTO `order` (`id_order`, `nama_tamu`, `jumlah_tamu`, `waktu`, `potongan`) VALUES
(1, 'William', 3, '2016-04-08', 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `ramen`
--

CREATE TABLE IF NOT EXISTS `ramen` (
  `id_ramen` int(11) NOT NULL AUTO_INCREMENT,
  `nama_ramen` varchar(200) NOT NULL,
  `harga_ramen` int(11) NOT NULL,
  PRIMARY KEY (`id_ramen`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data untuk tabel `ramen`
--

INSERT INTO `ramen` (`id_ramen`, `nama_ramen`, `harga_ramen`) VALUES
(1, 'Ramen Tom Yum', 20000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `snack`
--

CREATE TABLE IF NOT EXISTS `snack` (
  `id_snack` int(11) NOT NULL AUTO_INCREMENT,
  `nama_snack` varchar(200) NOT NULL,
  `harga_snack` int(11) NOT NULL,
  PRIMARY KEY (`id_snack`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data untuk tabel `snack`
--

INSERT INTO `snack` (`id_snack`, `nama_snack`, `harga_snack`) VALUES
(1, 'Okonomiyaki', 18000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `topping`
--

CREATE TABLE IF NOT EXISTS `topping` (
  `id_topping` int(11) NOT NULL AUTO_INCREMENT,
  `nama_topping` varchar(200) NOT NULL,
  `harga_topping` int(11) NOT NULL,
  PRIMARY KEY (`id_topping`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data untuk tabel `topping`
--

INSERT INTO `topping` (`id_topping`, `nama_topping`, `harga_topping`) VALUES
(1, 'Salmon Ball', 5000);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `list_dessert`
--
ALTER TABLE `list_dessert`
  ADD CONSTRAINT `dessert` FOREIGN KEY (`id_dessert`) REFERENCES `dessert` (`id_dessert`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `order` FOREIGN KEY (`id_order`) REFERENCES `order` (`id_order`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `list_minuman`
--
ALTER TABLE `list_minuman`
  ADD CONSTRAINT `list_minuman_ibfk_1` FOREIGN KEY (`id_order`) REFERENCES `order` (`id_order`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `minuman` FOREIGN KEY (`id_minuman`) REFERENCES `minuman` (`id_minuman`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `list_nasi`
--
ALTER TABLE `list_nasi`
  ADD CONSTRAINT `list_nasi_ibfk_1` FOREIGN KEY (`id_nasi`) REFERENCES `nasi` (`id_nasi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `list_nasi_ibfk_2` FOREIGN KEY (`id_order`) REFERENCES `order` (`id_order`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `list_ramen`
--
ALTER TABLE `list_ramen`
  ADD CONSTRAINT `list_ramen_ibfk_1` FOREIGN KEY (`id_ramen`) REFERENCES `ramen` (`id_ramen`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `list_ramen_ibfk_2` FOREIGN KEY (`id_order`) REFERENCES `order` (`id_order`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `list_snack`
--
ALTER TABLE `list_snack`
  ADD CONSTRAINT `list_snack_ibfk_1` FOREIGN KEY (`id_snack`) REFERENCES `snack` (`id_snack`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `list_snack_ibfk_2` FOREIGN KEY (`id_order`) REFERENCES `order` (`id_order`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `list_topping`
--
ALTER TABLE `list_topping`
  ADD CONSTRAINT `list_topping_ibfk_1` FOREIGN KEY (`id_topping`) REFERENCES `topping` (`id_topping`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `list_topping_ibfk_2` FOREIGN KEY (`id_order`) REFERENCES `order` (`id_order`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
