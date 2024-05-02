/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOremoveMGSStatusMasterDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.10.07 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOremoveMGSStatusMasterDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CGM_EQUIPMENT 업데이트
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOremoveMGSStatusMasterDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOremoveMGSStatusMasterDataUSQL").append("\n"); 
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
		query.append("UPDATE CGM_EQUIPMENT" ).append("\n"); 
		query.append("SET UPD_USR_ID       = @[cre_usr_id]" ).append("\n"); 
		query.append(",UPD_DT           = sysdate" ).append("\n"); 
		query.append(",ACIAC_DIV_CD = 'I'" ).append("\n"); 
		query.append(",ONH_OFC_CD           = NULL" ).append("\n"); 
		query.append(",ONH_DT               = NULL" ).append("\n"); 
		query.append(",ONH_YD_CD            = NULL" ).append("\n"); 
		query.append(",CRNT_YD_CD           = NULL" ).append("\n"); 
		query.append(",CRNT_LOC_CD          = NULL" ).append("\n"); 
		query.append(",CHSS_MVMT_DEST_YD_CD = NULL" ).append("\n"); 
		query.append(",CHSS_MVMT_STS_CD     = NULL" ).append("\n"); 
		query.append(",CHSS_MVMT_DT         = NULL" ).append("\n"); 
		query.append(",GATE_IO_CD           = NULL" ).append("\n"); 
		query.append(",ATCH_MGST_NO         = NULL" ).append("\n"); 
		query.append(",ACT_ONH_DT           = NULL" ).append("\n"); 
		query.append(",EQ_STS_SEQ       =  NVL(CGM_GET_EQ_STS_HIS_MAXSEQ_FNC(@[eq_no]) ,0)" ).append("\n"); 
		query.append("WHERE EQ_NO = @[eq_no]" ).append("\n"); 

	}
}