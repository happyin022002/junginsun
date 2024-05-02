/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EmptyCODAdjustmentDBDAOSearchRevenueMTYList02RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.31
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2014.03.31 신용찬
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YongChanShin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyCODAdjustmentDBDAOSearchRevenueMTYList02RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_CIM_1040
	  * Revenue MTY CNTR List
	  * </pre>
	  */
	public EmptyCODAdjustmentDBDAOSearchRevenueMTYList02RSQL(){
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
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.integration").append("\n"); 
		query.append("FileName : EmptyCODAdjustmentDBDAOSearchRevenueMTYList02RSQL").append("\n"); 
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
		query.append("SELECT	/*+ ORDERED INDEX( BV XAK1BKG_VVD ) */" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'D2' , NVL(CM.CNTR_HNGR_BAR_ATCH_KNT,0) , 0 ) )	D2		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'D4' , NVL(CM.CNTR_HNGR_BAR_ATCH_KNT,0) , 0 ) )	D4		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'D5' , NVL(CM.CNTR_HNGR_BAR_ATCH_KNT,0) , 0 ) )	D5		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'D7' , NVL(CM.CNTR_HNGR_BAR_ATCH_KNT,0) , 0 ) )	D7		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'R2' , NVL(CM.CNTR_HNGR_BAR_ATCH_KNT,0) , 0 ) )	R2		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'R5' , NVL(CM.CNTR_HNGR_BAR_ATCH_KNT,0) , 0 ) )	R5		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'R9' , NVL(CM.CNTR_HNGR_BAR_ATCH_KNT,0) , 0 ) )	R9		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'O2' , NVL(CM.CNTR_HNGR_BAR_ATCH_KNT,0) , 0 ) )	O2		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'S2' , NVL(CM.CNTR_HNGR_BAR_ATCH_KNT,0) , 0 ) )	S2		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'O4' , NVL(CM.CNTR_HNGR_BAR_ATCH_KNT,0) , 0 ) )	O4		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'S4' , NVL(CM.CNTR_HNGR_BAR_ATCH_KNT,0) , 0 ) )	S4		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'F2' , NVL(CM.CNTR_HNGR_BAR_ATCH_KNT,0) , 0 ) )	F2		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'A2' , NVL(CM.CNTR_HNGR_BAR_ATCH_KNT,0) , 0 ) )	A2		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'F4' , NVL(CM.CNTR_HNGR_BAR_ATCH_KNT,0) , 0 ) )	F4		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'A4' , NVL(CM.CNTR_HNGR_BAR_ATCH_KNT,0) , 0 ) )	A4		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'F5' , NVL(CM.CNTR_HNGR_BAR_ATCH_KNT,0) , 0 ) )	F5		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'O5' , NVL(CM.CNTR_HNGR_BAR_ATCH_KNT,0) , 0 ) )	O5		" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'D2' , 1 , 0 ) )	D2		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'D4' , 1 , 0 ) )	D4		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'D5' , 1 , 0 ) )	D5		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'D7' , 1 , 0 ) )	D7		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'R2' , 1 , 0 ) )	R2		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'R5' , 1 , 0 ) )	R5		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'R9' , 1 , 0 ) )	R9		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'O2' , 1 , 0 ) )	O2		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'S2' , 1 , 0 ) )	S2		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'O4' , 1 , 0 ) )	O4		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'S4' , 1 , 0 ) )	S4		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'F2' , 1 , 0 ) )	F2		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'A2' , 1 , 0 ) )	A2		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'F4' , 1 , 0 ) )	F4		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'A4' , 1 , 0 ) )	A4		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'F5' , 1 , 0 ) )	F5		," ).append("\n"); 
		query.append("                SUM	( DECODE( CM.CNTR_TPSZ_CD , 'O5' , 1 , 0 ) )	O5		" ).append("\n"); 
		query.append("        FROM	(" ).append("\n"); 
		query.append("                    SELECT	BPN.CNTR_REF_NO				CNTR_NO," ).append("\n"); 
		query.append("                            BPN.POL_CD					POL_CD," ).append("\n"); 
		query.append("                            BPN.POD_CD					POD_CD," ).append("\n"); 
		query.append("                            BPN.VSL_BAY_NO||BPN.VSL_ROW_NO||BPN.VSL_TR_NO		BAY_NO" ).append("\n"); 
		query.append("                    FROM	OPF_BAY_PLN_LDIS	BPN " ).append("\n"); 
		query.append("                    WHERE	BPN.VSL_CD				=	SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                    AND		BPN.SKD_VOY_NO			=	SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                    AND		BPN.SKD_DIR_CD			=	SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                    AND		BPN.LODG_DCHG_IND_CD	=	'C'" ).append("\n"); 
		query.append("                    AND		BPN.FULL_MTY_CD			=	'E'" ).append("\n"); 
		query.append("                    AND		BPN.CRR_CD	=	'HJS'" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                )					BP," ).append("\n"); 
		query.append("                BKG_VVD				BV," ).append("\n"); 
		query.append("                BKG_BOOKING			BK," ).append("\n"); 
		query.append("                BKG_CONTAINER		BC," ).append("\n"); 
		query.append("                MST_CONTAINER		CM" ).append("\n"); 
		query.append("        WHERE	BV.VSL_CD			=	SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("        AND		BV.SKD_VOY_NO		=	SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("        AND		BV.SKD_DIR_CD		=	SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("        AND		BV.POD_CD			=	DECODE(@[pod],'',BV.POD_CD,@[pod])" ).append("\n"); 
		query.append("        AND		BV.BKG_NO			=	BK.BKG_NO" ).append("\n"); 
		query.append("        AND		BK.BKG_CGO_TP_CD	=	'R'" ).append("\n"); 
		query.append("        AND		BK.BKG_NO			=	BC.BKG_NO" ).append("\n"); 
		query.append("        AND		BC.CNTR_NO			=	BP.CNTR_NO	" ).append("\n"); 
		query.append("        AND		BC.CNTR_NO			=	CM.CNTR_NO" ).append("\n"); 

	}
}