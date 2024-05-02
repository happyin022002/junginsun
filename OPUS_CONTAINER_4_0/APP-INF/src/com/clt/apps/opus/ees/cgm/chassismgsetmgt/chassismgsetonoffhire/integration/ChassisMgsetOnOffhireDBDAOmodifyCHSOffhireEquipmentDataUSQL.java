/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOmodifyCHSOffhireEquipmentDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.01.26 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOmodifyCHSOffhireEquipmentDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CGM_EQUIPMENT 업데이트
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOmodifyCHSOffhireEquipmentDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_evnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOmodifyCHSOffhireEquipmentDataUSQL").append("\n"); 
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
		query.append("SET ACIAC_DIV_CD = 'I'" ).append("\n"); 
		query.append(",CRNT_YD_CD   = @[sts_evnt_yd_cd]" ).append("\n"); 
		query.append(",CRNT_LOC_CD  = SUBSTR(@[sts_evnt_yd_cd],0,5)" ).append("\n"); 
		query.append(",CHSS_MVMT_STS_CD = 'XX'" ).append("\n"); 
		query.append(",EQ_STS_SEQ       =  NVL(CGM_GET_EQ_STS_HIS_MAXSEQ_FNC(@[eq_no]) ,0)" ).append("\n"); 
		query.append(",CHSS_MVMT_DT     = TO_DATE(@[sts_evnt_dt] || '23:59','YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append(",UPD_USR_ID       = @[user_id]" ).append("\n"); 
		query.append(",UPD_DT           = sysdate" ).append("\n"); 
		query.append("WHERE EQ_NO = @[eq_no]" ).append("\n"); 

	}
}