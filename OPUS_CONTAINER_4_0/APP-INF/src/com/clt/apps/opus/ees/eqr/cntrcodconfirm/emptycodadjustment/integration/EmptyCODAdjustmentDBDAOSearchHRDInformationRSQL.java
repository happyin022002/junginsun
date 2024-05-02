/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EmptyCODAdjustmentDBDAOSearchHRDInformationRSQL.java
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

public class EmptyCODAdjustmentDBDAOSearchHRDInformationRSQL implements ISQLTemplate{

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
	public EmptyCODAdjustmentDBDAOSearchHRDInformationRSQL(){
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
		query.append("FileName : EmptyCODAdjustmentDBDAOSearchHRDInformationRSQL").append("\n"); 
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
		query.append("SELECT  /*+ ORDERED USE_NL( BP BV BK BC CM ) */ " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("        SUM(DECODE(CM.CNTR_HNGR_RCK_CD,NULL,0,1)) || '|' ||         /* Hanger Count */   /* 2010.03.15 By SBKIM */" ).append("\n"); 
		query.append("        SUM(DECODE(CM.DMG_FLG,'Y',1,0))           || '|' ||         /* Damage Count */" ).append("\n"); 
		query.append("        SUM(DECODE(BK.BKG_CGO_TP_CD,'R',1,0))                          /* Revenue Count */      " ).append("\n"); 
		query.append("	) AS TXTHRD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("        OPF_BAY_PLN_LDIS 	BP," ).append("\n"); 
		query.append("        BKG_VVD    			BV," ).append("\n"); 
		query.append("        BKG_BOOKING   		BK," ).append("\n"); 
		query.append("        BKG_CONTAINER  		BC," ).append("\n"); 
		query.append("        MST_CONTAINER  		CM" ).append("\n"); 
		query.append("WHERE BP.VSL_CD    			= SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND  BP.SKD_VOY_NO   		= SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND  BP.SKD_DIR_CD   		= SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND  BP.LODG_DCHG_IND_CD  	= 'C'" ).append("\n"); 
		query.append("AND  BP.FULL_MTY_CD   		= 'E'" ).append("\n"); 
		query.append("AND  BP.CRR_CD              = 'HJS'" ).append("\n"); 
		query.append("AND  BP.VSL_CD   			= BV.VSL_CD" ).append("\n"); 
		query.append("AND  BP.SKD_VOY_NO  		= BV.SKD_VOY_NO" ).append("\n"); 
		query.append("AND  BP.SKD_DIR_CD  		= BV.SKD_DIR_CD" ).append("\n"); 
		query.append("AND  BV.BKG_NO   			= BK.BKG_NO" ).append("\n"); 
		query.append("AND  BK.BKG_NO   			= BC.BKG_NO" ).append("\n"); 
		query.append("AND  BC.CNTR_NO   			= BP.CNTR_REF_NO" ).append("\n"); 
		query.append("AND  BC.CNTR_NO   			= CM.CNTR_NO" ).append("\n"); 

	}
}