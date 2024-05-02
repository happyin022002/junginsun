/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustomsCommonMgtDBDAOremoveCstmsPckTpConvDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.14
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.05.14 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomsCommonMgtDBDAOremoveCstmsPckTpConvDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * removeCstmsPckTpConv
	  * </pre>
	  */
	public CustomsCommonMgtDBDAOremoveCstmsPckTpConvDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcvr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.integration").append("\n"); 
		query.append("FileName : CustomsCommonMgtDBDAOremoveCstmsPckTpConvDSQL").append("\n"); 
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
		query.append("DELETE " ).append("\n"); 
		query.append("  FROM BKG_CSTMS_PCK_TP_CONV" ).append("\n"); 
		query.append(" WHERE CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("   AND PCK_TP_CD = @[pck_tp_cd]" ).append("\n"); 
		query.append("   AND CSTMS_PCK_TP_CD = @[cstms_pck_tp_cd]" ).append("\n"); 
		query.append("   AND RCVR_ID = @[rcvr_id]" ).append("\n"); 

	}
}