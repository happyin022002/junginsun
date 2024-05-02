/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel05RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.21
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.12.21 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel05RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Match-back by Vessel
	  * </pre>
	  */
	public EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel05RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration").append("\n"); 
		query.append("FileName : EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel05RSQL").append("\n"); 
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
		query.append("'BKG' val01,																						/* dataSource */" ).append("\n"); 
		query.append("COUNT(DECODE(BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CNTR_TPSZ_CD,2,1), '2', CNTR_TPSZ_CD))) val02,		/* full20Qty */" ).append("\n"); 
		query.append("COUNT(DECODE(BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CNTR_TPSZ_CD,2,1), '4', CNTR_TPSZ_CD))) val03,		/* full40Qty */" ).append("\n"); 
		query.append("COUNT(DECODE(BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CNTR_TPSZ_CD,2,1), '5', CNTR_TPSZ_CD))) val04,		/* fullHcQty */" ).append("\n"); 
		query.append("COUNT(DECODE(BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CNTR_TPSZ_CD,2,1), '7', CNTR_TPSZ_CD))) val05,		/* full45Qty */" ).append("\n"); 
		query.append("COUNT(DECODE(BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(CNTR_TPSZ_CD,2,1), '2', CNTR_TPSZ_CD))) val06,		/* mty20Qty  */" ).append("\n"); 
		query.append("COUNT(DECODE(BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(CNTR_TPSZ_CD,2,1), '4', CNTR_TPSZ_CD))) val07,		/* mty40Qty  */" ).append("\n"); 
		query.append("COUNT(DECODE(BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(CNTR_TPSZ_CD,2,1), '5', CNTR_TPSZ_CD))) val08,		/* mtyHcQty  */" ).append("\n"); 
		query.append("COUNT(DECODE(BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(CNTR_TPSZ_CD,2,1), '7', CNTR_TPSZ_CD))) val09,		/* mty45Qty  */" ).append("\n"); 
		query.append("COUNT(DECODE(AWK_CGO_FLG, 'Y', CNTR_NO)) deadSlot" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("/*+" ).append("\n"); 
		query.append("ORDERED USE_NL ( BV SL SD BK BC )" ).append("\n"); 
		query.append("INDEX( BV XAK1BKG_VVD )" ).append("\n"); 
		query.append("INDEX( BC XPKBKG_CONTAINER )" ).append("\n"); 
		query.append("INDEX( BK XPKBKG_BOOKING )" ).append("\n"); 
		query.append("INDEX( SL XPKVSK_VSL_PORT_SKD )" ).append("\n"); 
		query.append("INDEX( SD XPKVSK_VSL_PORT_SKD )" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("BK.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("BC.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("BC.CNTR_NO," ).append("\n"); 
		query.append("MAX(BC.AWK_CGO_FLG)		AWK_CGO_FLG," ).append("\n"); 
		query.append("1						TEMP" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_VVD		        BV," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD	SL," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD	SD," ).append("\n"); 
		query.append("BKG_BOOKING			BK," ).append("\n"); 
		query.append("BKG_CONTAINER		BC" ).append("\n"); 
		query.append("WHERE  	BK.BKG_NO			= BC.BKG_NO" ).append("\n"); 
		query.append("--					AND    	BK.BKG_NO_SPLIT		= BC.BKG_NO_SPLIT" ).append("\n"); 
		query.append("AND    	BK.BKG_NO			= BV.BKG_NO" ).append("\n"); 
		query.append("--					AND    	BK.BKG_NO_SPLIT		= BV.BKG_NO_SPLIT" ).append("\n"); 
		query.append("AND    	BV.VSL_CD 			= SUBSTR(@[trade],1,4) -- vvd" ).append("\n"); 
		query.append("AND    	BV.SKD_VOY_NO		= SUBSTR(@[trade],5,4) -- vvd" ).append("\n"); 
		query.append("AND    	BV.SKD_DIR_CD		= SUBSTR(@[trade],9,1) -- vvd" ).append("\n"); 
		query.append("AND    	SL.VSL_CD 			= BV.VSL_CD" ).append("\n"); 
		query.append("AND    	SL.SKD_VOY_NO		= BV.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    	SL.SKD_DIR_CD		= BV.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    	SL.VPS_PORT_CD		= BV.POL_CD" ).append("\n"); 
		query.append("AND    	SL.CLPT_SEQ			<= @[lane] -- call_seq" ).append("\n"); 
		query.append("AND    	SD.VSL_CD			= BV.VSL_CD" ).append("\n"); 
		query.append("AND    	SD.SKD_VOY_NO		= BV.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    	SD.SKD_DIR_CD		= BV.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    	SD.VPS_PORT_CD		= DECODE(BV.POD_CD, 'XXXXX', BV.POL_CD, BV.POD_CD)" ).append("\n"); 
		query.append("AND    	SD.CLPT_SEQ			> DECODE(BV.POD_CD, 'XXXXX', SD.CLPT_SEQ-1, @[lane]) -- call_seq" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("BK.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("BC.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("BC.CNTR_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY TEMP" ).append("\n"); 

	}
}