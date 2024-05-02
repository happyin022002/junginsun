/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOmodifyMGSStatusHistoryDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.07.07 최민회
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

public class ChassisMgsetOnOffhireDBDAOmodifyMGSStatusHistoryDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CGM_EQ_STS_HIS 업데이트
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOmodifyMGSStatusHistoryDataUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_evnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});
		
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});
		
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});
		
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});
		
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});
		
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_sts_seq",new String[]{arrTmp[0],arrTmp[1]});
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
		query.append("UPDATE CGM_EQ_STS_HIS" ).append("\n"); 
		query.append("SET STS_EVNT_YD_CD     = @[sts_evnt_yd_cd]" ).append("\n"); 
		query.append(",STS_EVNT_LOC_CD    = SUBSTR(@[sts_evnt_yd_cd],0,5)" ).append("\n"); 
		query.append(",STS_EVNT_DT        = @[sts_evnt_dt]" ).append("\n"); 
		query.append(",AGMT_OFC_CTY_CD    = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append(",AGMT_SEQ	        = @[agmt_seq]" ).append("\n"); 
		query.append(",UPD_USR_ID         = @[cre_usr_id]" ).append("\n"); 
		query.append(",UPD_DT             = sysdate" ).append("\n"); 
		query.append("WHERE EQ_NO            = @[eq_no]" ).append("\n"); 
		query.append("AND EQ_STS_SEQ       = @[eq_sts_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOmodifyMGSStatusHistoryDataUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}