/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EQMatchBackNLoadFactorMgtDBDAOLoadFactorByTradeLaneVvdQTYVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.26
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.11.26 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQMatchBackNLoadFactorMgtDBDAOLoadFactorByTradeLaneVvdQTYVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public EQMatchBackNLoadFactorMgtDBDAOLoadFactorByTradeLaneVvdQTYVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromregion",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("company",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("callSeq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration").append("\n"); 
		query.append("FileName : EQMatchBackNLoadFactorMgtDBDAOLoadFactorByTradeLaneVvdQTYVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT" ).append("\n"); 
		query.append("/*+" ).append("\n"); 
		query.append("ORDERED USE_NL ( RD BV SL SD BK BC )" ).append("\n"); 
		query.append("INDEX( BV XAK2BKG_VVD )" ).append("\n"); 
		query.append("INDEX( BC XAK3BKG_CONTAINER )" ).append("\n"); 
		query.append("INDEX( BK XPKBKG_BOOKING )" ).append("\n"); 
		query.append("INDEX( SL XPKVSK_VSL_PORT_SKD )" ).append("\n"); 
		query.append("INDEX( SD XPKVSK_VSL_PORT_SKD )" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("RD.R_DATASOURCE dataSource," ).append("\n"); 
		query.append("RD.R_FULL20QTY	full20Qty ," ).append("\n"); 
		query.append("RD.R_FULL40QTY	full40Qty," ).append("\n"); 
		query.append("RD.R_FULLHCQTY	fullHcQty," ).append("\n"); 
		query.append("RD.R_FULL45QTY	full45Qty," ).append("\n"); 
		query.append("RD.R_MTY20QTY	mty20Qty," ).append("\n"); 
		query.append("RD.R_MTY40QTY	mty40Qty," ).append("\n"); 
		query.append("RD.R_MTYHCQTY	mtyHcQty," ).append("\n"); 
		query.append("RD.R_MTY45QTY	mty45Qty," ).append("\n"); 
		query.append("NVL(RD.R_WEIGHTTTL,0)	weightTotal," ).append("\n"); 
		query.append("-------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("'BKG' 																			                dataSource_b," ).append("\n"); 
		query.append("COUNT(DECODE(BK.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(BC.CNTR_TPSZ_CD,2,1), '2', BC.CNTR_TPSZ_CD))) full20Qty_b	," ).append("\n"); 
		query.append("COUNT(DECODE(BK.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(BC.CNTR_TPSZ_CD,2,1), '4', BC.CNTR_TPSZ_CD))) full40Qty_b	," ).append("\n"); 
		query.append("COUNT(DECODE(BK.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(BC.CNTR_TPSZ_CD,2,1), '5', BC.CNTR_TPSZ_CD))) fullHcQty_b	," ).append("\n"); 
		query.append("COUNT(DECODE(BK.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(BC.CNTR_TPSZ_CD,2,1), '7', BC.CNTR_TPSZ_CD))) full45Qty_b	," ).append("\n"); 
		query.append("COUNT(DECODE(BK.BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(BC.CNTR_TPSZ_CD,2,1), '2', BC.CNTR_TPSZ_CD))) mty20Qty_b	," ).append("\n"); 
		query.append("COUNT(DECODE(BK.BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(BC.CNTR_TPSZ_CD,2,1), '4', BC.CNTR_TPSZ_CD))) mty40Qty_b	," ).append("\n"); 
		query.append("COUNT(DECODE(BK.BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(BC.CNTR_TPSZ_CD,2,1), '5', BC.CNTR_TPSZ_CD))) mtyHcQty_b	," ).append("\n"); 
		query.append("COUNT(DECODE(BK.BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(BC.CNTR_TPSZ_CD,2,1), '7', BC.CNTR_TPSZ_CD))) mty45Qty_b	," ).append("\n"); 
		query.append("COUNT(DECODE(BC.AWK_CGO_FLG, 'Y', BC.CNTR_NO)) 												    deadSlot" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	/*+ ORDERED USE_NL(H M) */" ).append("\n"); 
		query.append("SUBSTR(@[vvd],1,4)																	R_VSL		," ).append("\n"); 
		query.append("SUBSTR(@[vvd],5,4)																	R_VOY		," ).append("\n"); 
		query.append("SUBSTR(@[vvd],9,1)																	R_DIR		," ).append("\n"); 
		query.append("'RDR'																					R_DATASOURCE," ).append("\n"); 
		query.append("--  DECODE(CNTR_SIZE,'2','20','3','2H','4','40','H','4H','L','45') CNTR_SIZE, SUM(M.QTY) QTY,  WGT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("MAX(NVL(SUM( DECODE(  M.CNTR_TYPE, 'F', DECODE( M.CNTR_SIZE, '2', M.QTY, 0  ), 0 )),0)) R_FULL20QTY	," ).append("\n"); 
		query.append("MAX(NVL(SUM( DECODE(  M.CNTR_TYPE, 'F', DECODE( M.CNTR_SIZE, '4', M.QTY, 0  ), 0 )),0)) R_FULL40QTY	," ).append("\n"); 
		query.append("MAX(NVL(SUM( DECODE(  M.CNTR_TYPE, 'F', DECODE( M.CNTR_SIZE, 'H', M.QTY, 0  ), 0 )),0)) R_FULLHCQTY	," ).append("\n"); 
		query.append("MAX(NVL(SUM( DECODE(  M.CNTR_TYPE, 'F', DECODE( M.CNTR_SIZE, 'L', M.QTY, 0  ), 0 )),0)) R_FULL45QTY	," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("MAX(NVL(SUM( DECODE(  M.CNTR_TYPE, 'E', DECODE( M.CNTR_SIZE, '2', M.QTY, 0  ), 0 )),0)) R_MTY20QTY	," ).append("\n"); 
		query.append("MAX(NVL(SUM( DECODE(  M.CNTR_TYPE, 'E', DECODE( M.CNTR_SIZE, '4', M.QTY, 0  ), 0 )),0)) R_MTY40QTY	," ).append("\n"); 
		query.append("MAX(NVL(SUM( DECODE(  M.CNTR_TYPE, 'E', DECODE( M.CNTR_SIZE, 'H', M.QTY, 0  ), 0 )),0)) R_MTYHCQTY	," ).append("\n"); 
		query.append("MAX(NVL(SUM( DECODE(  M.CNTR_TYPE, 'E', DECODE( M.CNTR_SIZE, 'L', M.QTY, 0  ), 0 )),0)) R_MTY45QTY	," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("MAX(NVL(SUM( DECODE( M.CNTR_SIZE, '2', M.WEIGHT, 0  ) ),0)) +" ).append("\n"); 
		query.append("MAX(NVL(SUM( DECODE( M.CNTR_SIZE, '4', M.WEIGHT, 0  ) ),0)) +" ).append("\n"); 
		query.append("MAX(NVL(SUM( DECODE( M.CNTR_SIZE, 'H', M.WEIGHT, 0  ) ),0)) +" ).append("\n"); 
		query.append("MAX(NVL(SUM( DECODE( M.CNTR_SIZE, 'L', M.WEIGHT, 0  ) ),0))								R_WEIGHTTTL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	RDR_HEADER		H," ).append("\n"); 
		query.append("RDR_SUMMARY		M" ).append("\n"); 
		query.append("WHERE	H.VSL_CD 	= SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND		H.VOY_NO 	= SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND		H.DIR_CD 	= SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND     H.REGION    = @[fromregion]       /* from_region */" ).append("\n"); 
		query.append("--				AND		H.PORT_CD	= 'SGSIN'   /* 삭제 */" ).append("\n"); 
		query.append("AND		H.VSL_CD	= M.VSL_CD" ).append("\n"); 
		query.append("AND		H.VOY_NO	= M.VOY_NO" ).append("\n"); 
		query.append("AND		H.DIR_CD	= M.DIR_CD" ).append("\n"); 
		query.append("AND		H.REGION	= M.REGION" ).append("\n"); 
		query.append("AND		M.OPR_CD	= @[company]" ).append("\n"); 
		query.append("GROUP BY 1" ).append("\n"); 
		query.append(")					RD," ).append("\n"); 
		query.append("BKG_VVD		        BV," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD	SL," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD	SD," ).append("\n"); 
		query.append("BKG_BOOKING			BK," ).append("\n"); 
		query.append("BKG_CONTAINER		BC" ).append("\n"); 
		query.append("WHERE  	RD.R_VSL			=	BV.VSL_CD" ).append("\n"); 
		query.append("AND		RD.R_VOY			=	BV.SKD_VOY_NO" ).append("\n"); 
		query.append("AND		RD.R_DIR			=	BV.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    	BK.BKG_NO			=	BV.BKG_NO" ).append("\n"); 
		query.append("AND		BK.BKG_NO			=	BC.BKG_NO" ).append("\n"); 
		query.append("AND    	SL.VSL_CD 			=	BV.VSL_CD" ).append("\n"); 
		query.append("AND    	SL.SKD_VOY_NO		=	BV.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    	SL.SKD_DIR_CD		=	BV.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    	SL.VPS_PORT_CD		=	BV.POL_CD" ).append("\n"); 
		query.append("AND    	SL.CLPT_SEQ			<= @[callSeq]" ).append("\n"); 
		query.append("AND    	SD.VSL_CD			=	BV.VSL_CD" ).append("\n"); 
		query.append("AND    	SD.SKD_VOY_NO		=	BV.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    	SD.SKD_DIR_CD		=	BV.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    	SD.VPS_PORT_CD		=	DECODE(BV.POD_CD, 'XXXXX', BV.POL_CD, BV.POD_CD)" ).append("\n"); 
		query.append("AND    	SD.CLPT_SEQ			>	DECODE(BV.POD_CD, 'XXXXX', SD.CLPT_SEQ-1, @[callSeq])" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("RD.R_DATASOURCE ," ).append("\n"); 
		query.append("RD.R_FULL20QTY	," ).append("\n"); 
		query.append("RD.R_FULL40QTY	," ).append("\n"); 
		query.append("RD.R_FULLHCQTY	," ).append("\n"); 
		query.append("RD.R_FULL45QTY	," ).append("\n"); 
		query.append("RD.R_MTY20QTY	," ).append("\n"); 
		query.append("RD.R_MTY40QTY	," ).append("\n"); 
		query.append("RD.R_MTYHCQTY	," ).append("\n"); 
		query.append("RD.R_MTY45QTY	," ).append("\n"); 
		query.append("RD.R_WEIGHTTTL" ).append("\n"); 

	}
}