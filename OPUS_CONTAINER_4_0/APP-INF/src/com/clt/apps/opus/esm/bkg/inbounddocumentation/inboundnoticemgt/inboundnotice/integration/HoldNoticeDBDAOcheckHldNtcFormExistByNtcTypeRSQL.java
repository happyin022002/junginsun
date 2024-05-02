/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HoldNoticeDBDAOcheckHldNtcFormExistByNtcTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.04
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.04 
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

public class HoldNoticeDBDAOcheckHldNtcFormExistByNtcTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public HoldNoticeDBDAOcheckHldNtcFormExistByNtcTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hld_ntc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration ").append("\n"); 
		query.append("FileName : HoldNoticeDBDAOcheckHldNtcFormExistByNtcTypeRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT 'Y' AS NTC_WD_YN" ).append("\n"); 
		query.append("FROM BKG_HLD_WD WD" ).append("\n"); 
		query.append("WHERE WD.HLD_NTC_TP_CD      = @[hld_ntc_tp_cd]" ).append("\n"); 
		query.append("AND   WD.OFC_CD             = @[ofc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${hld_ntc_tp_cd} == 'PH')" ).append("\n"); 
		query.append("AND   WD.POD_CD             = @[pod_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND   WD.POD_CD             IN ('*',@[pod_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}