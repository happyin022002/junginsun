/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EmptyCODAdjustmentDBDAOSearchBayplanVVDRSQL.java
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

public class EmptyCODAdjustmentDBDAOSearchBayplanVVDRSQL implements ISQLTemplate{

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
	public EmptyCODAdjustmentDBDAOSearchBayplanVVDRSQL(){
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
		query.append("FileName : EmptyCODAdjustmentDBDAOSearchBayplanVVDRSQL").append("\n"); 
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
		query.append("SELECT	DISTINCT" ).append("\n"); 
		query.append("			V.SLAN_CD || '|' || B.VPS_PORT_CD || DECODE(B.VSL_CD,NULL,'|||','|I||') AS XXX" ).append("\n"); 
		query.append("	FROM	VSK_VSL_PORT_SKD	V," ).append("\n"); 
		query.append("			OPF_BAY_PLN_LDIS	B " ).append("\n"); 
		query.append("	WHERE	V.VSL_CD			=	SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("	AND		V.SKD_VOY_NO		=	SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("	AND		V.SKD_DIR_CD		=	SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("	AND		V.VSL_CD			=	B.VSL_CD     " ).append("\n"); 
		query.append("	AND		V.SKD_VOY_NO		=	B.SKD_VOY_NO " ).append("\n"); 
		query.append("	AND		V.SKD_DIR_CD		=	B.SKD_DIR_CD   " ).append("\n"); 
		query.append("	AND		B.LODG_DCHG_IND_CD	=	'C'" ).append("\n"); 
		query.append("	AND		B.FULL_MTY_CD		=	'E'" ).append("\n"); 
		query.append("	AND		B.CRR_CD			=	'HJS'" ).append("\n"); 

	}
}