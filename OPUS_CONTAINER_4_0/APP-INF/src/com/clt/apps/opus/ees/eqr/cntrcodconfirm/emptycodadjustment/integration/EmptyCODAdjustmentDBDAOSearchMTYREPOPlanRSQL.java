/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EmptyCODAdjustmentDBDAOSearchMTYREPOPlanRSQL.java
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

public class EmptyCODAdjustmentDBDAOSearchMTYREPOPlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI_CIM_1039
	  * MTY COD Confirmation
	  * </pre>
	  */
	public EmptyCODAdjustmentDBDAOSearchMTYREPOPlanRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.integration").append("\n"); 
		query.append("FileName : EmptyCODAdjustmentDBDAOSearchMTYREPOPlanRSQL").append("\n"); 
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
		query.append("SELECT	B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD			VVD		," ).append("\n"); 
		query.append("			B.POD_CD										POD_CD	, " ).append("\n"); 
		query.append("			SUBSTR(V.YD_CD,6,2)								YD_CD	," ).append("\n"); 
		query.append("			TO_CHAR(V.VPS_ETB_DT,'YYYYMMDD')				ETB		," ).append("\n"); 
		query.append("			SUM	( DECODE(B.CNTR_TPSZ_CD,'D2',1,0 ) )	D2		," ).append("\n"); 
		query.append("			SUM	( DECODE(B.CNTR_TPSZ_CD,'D4',1,0 ) )	D4		," ).append("\n"); 
		query.append("			SUM	( DECODE(B.CNTR_TPSZ_CD,'D5',1,0 ) )	D5		," ).append("\n"); 
		query.append("			SUM	( DECODE(B.CNTR_TPSZ_CD,'D7',1,0 ) )	D7		," ).append("\n"); 
		query.append("			SUM	( DECODE(B.CNTR_TPSZ_CD,'R2',1,0 ) )	R2		," ).append("\n"); 
		query.append("			SUM	( DECODE(B.CNTR_TPSZ_CD,'R5',1,0 ) )	R5		," ).append("\n"); 
		query.append("			SUM	( DECODE(B.CNTR_TPSZ_CD,'O2',1,0 ) )	O2		," ).append("\n"); 
		query.append("			SUM	( DECODE(B.CNTR_TPSZ_CD,'S2',1,0 ) )	S2		," ).append("\n"); 
		query.append("			SUM	( DECODE(B.CNTR_TPSZ_CD,'O4',1,0 ) )	O4		," ).append("\n"); 
		query.append("			SUM	( DECODE(B.CNTR_TPSZ_CD,'S4',1,0 ) )	S4		," ).append("\n"); 
		query.append("			SUM	( DECODE(B.CNTR_TPSZ_CD,'F2',1,0 ) )	F2		," ).append("\n"); 
		query.append("			SUM	( DECODE(B.CNTR_TPSZ_CD,'A2',1,0 ) )	A2		," ).append("\n"); 
		query.append("			SUM	( DECODE(B.CNTR_TPSZ_CD,'F4',1,0 ) )	F4		," ).append("\n"); 
		query.append("			SUM	( DECODE(B.CNTR_TPSZ_CD,'A4',1,0 ) )	A4		," ).append("\n"); 
		query.append("			SUM	( DECODE(B.CNTR_TPSZ_CD,'F5',1,0 ) )	F5		" ).append("\n"); 
		query.append("	FROM	" ).append("\n"); 
		query.append("			OPF_BAY_PLN_LDIS	B, " ).append("\n"); 
		query.append("			MST_CONTAINER		C," ).append("\n"); 
		query.append("			VSK_VSL_PORT_SKD	V" ).append("\n"); 
		query.append("	WHERE	B.VSL_CD			=	SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("	AND		B.SKD_VOY_NO		=	SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("	AND		B.SKD_DIR_CD		=	SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("	AND		B.LODG_DCHG_IND_CD	=	'C'		  /* Cod Confirmation */" ).append("\n"); 
		query.append("	AND		B.FULL_MTY_CD		=	'E'" ).append("\n"); 
		query.append("	AND		B.CRR_CD	=	'HJS'" ).append("\n"); 
		query.append("    AND     B.CNTR_REF_NO       =   C.CNTR_NO" ).append("\n"); 
		query.append("	AND		C.LSTM_CD			<>	'SH'" ).append("\n"); 
		query.append("	AND		B.VSL_CD		=	V.VSL_CD" ).append("\n"); 
		query.append("	AND		B.SKD_VOY_NO	=	V.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND		B.SKD_DIR_CD	=	V.SKD_DIR_CD" ).append("\n"); 
		query.append("	AND     B.POD_CD       =    V.VPS_PORT_CD" ).append("\n"); 
		query.append("	AND		NVL(V.SKD_CNG_STS_CD,	' ')	<> 'S'" ).append("\n"); 
		query.append("	AND		B.POL_CD	IN	(" ).append("\n"); 
		query.append("								SELECT	VPS_PORT_CD" ).append("\n"); 
		query.append("								FROM	VSK_VSL_PORT_SKD	VV" ).append("\n"); 
		query.append("								WHERE	VV.VSL_CD		=	B.VSL_CD" ).append("\n"); 
		query.append("								AND		VV.SKD_VOY_NO	=	SKD_VOY_NO" ).append("\n"); 
		query.append("								AND		VV.SKD_DIR_CD	=	SKD_DIR_CD" ).append("\n"); 
		query.append("								AND		NVL(VV.SKD_CNG_STS_CD,	' ')	<> 'S'" ).append("\n"); 
		query.append("								AND		NVL(VV.TURN_PORT_FLG,	' ')	IN	('Y','N') " ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("	GROUP BY" ).append("\n"); 
		query.append("	       	B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD	," ).append("\n"); 
		query.append("			B.POD_CD					,	" ).append("\n"); 
		query.append("			SUBSTR(V.YD_CD,6,2)			," ).append("\n"); 
		query.append("			TO_CHAR(V.VPS_ETB_DT,'YYYYMMDD')" ).append("\n"); 

	}
}