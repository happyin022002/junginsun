/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : HoldNoticeDBDAOsearchWnFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HoldNoticeDBDAOsearchWnFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public HoldNoticeDBDAOsearchWnFlgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_dspo_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration ").append("\n"); 
		query.append("FileName : HoldNoticeDBDAOsearchWnFlgRSQL").append("\n"); 
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
		query.append("SELECT CNT_CD" ).append("\n"); 
		query.append("      ,CSTMS_DSPO_CD" ).append("\n"); 
		query.append("      ,CSTMS_DSPO_NM" ).append("\n"); 
		query.append("      ,DSPO_DESC" ).append("\n"); 
		query.append("      ,CSTMS_PAIR_DSPO_CD" ).append("\n"); 
		query.append("      ,DSPO_TP_CD" ).append("\n"); 
		query.append("      ,OB_NTC_FLG" ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      ,AUTO_NTC_FLG" ).append("\n"); 
		query.append("      ,DIFF_RMK" ).append("\n"); 
		query.append("      ,USA_CSTMS_ENTR_FLG" ).append("\n"); 
		query.append("      ,USA_CSTMS_RLSE_FLG" ).append("\n"); 
		query.append("      ,USA_CSTMS_ENTR_ICRZ_FLG" ).append("\n"); 
		query.append("      ,USA_CSTMS_RLSE_ICRZ_FLG" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_ADV_DSPO" ).append("\n"); 
		query.append("WHERE  CNT_CD             = 'US'" ).append("\n"); 
		query.append("AND    DELT_FLG           = 'N'" ).append("\n"); 
		query.append("AND    CSTMS_DSPO_CD      = @[cstms_dspo_cd] -- Code" ).append("\n"); 

	}
}