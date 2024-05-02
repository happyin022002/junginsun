/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ContainerOnOffHireDBDAOModifyMvmtHistorybyUpdateDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.04
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2017.01.04 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffHireDBDAOModifyMvmtHistorybyUpdateDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Movement Type Flag이 'E'인 경우에 대하여 Event Data를 Update 하도록 기능 변경
	  * </pre>
	  */
	public ContainerOnOffHireDBDAOModifyMvmtHistorybyUpdateDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sts_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffHireDBDAOModifyMvmtHistorybyUpdateDataUSQL").append("\n"); 
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
		query.append("UPDATE CTM_MOVEMENT CM" ).append("\n"); 
		query.append("SET CNMV_EVNT_DT = TO_DATE(@[cntr_sts_evnt_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("                       + CASE @[cntr_sts_cd] " ).append("\n"); 
		query.append("                              WHEN 'OWN' THEN 0" ).append("\n"); 
		query.append("                              WHEN 'LSI' THEN 0" ).append("\n"); 
		query.append("                              WHEN 'SBO' THEN 0.99999" ).append("\n"); 
		query.append("                              WHEN 'MUO' THEN 0.99999" ).append("\n"); 
		query.append("                              WHEN 'LSO' THEN 0.99999" ).append("\n"); 
		query.append("                              WHEN 'MUI' THEN 0" ).append("\n"); 
		query.append("                              WHEN 'SBI' THEN 0" ).append("\n"); 
		query.append("                          ELSE" ).append("\n"); 
		query.append("                              0" ).append("\n"); 
		query.append("                          END" ).append("\n"); 
		query.append("  , CTRT_OFC_CTY_CD      = @[agmt_cty_cd]" ).append("\n"); 
		query.append("  , CTRT_SEQ         = @[agmt_seq]" ).append("\n"); 
		query.append("  , UPD_DT           = SYSDATE" ).append("\n"); 
		query.append("  , UPD_USR_ID       = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND CM.CNTR_NO      = (SELECT /*+ INDEX( A XPKMST_CONTAINER) */" ).append("\n"); 
		query.append("                 CNTR_NO " ).append("\n"); 
		query.append("                 FROM MST_CONTAINER A" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                 ##${cntr_no}" ).append("\n"); 
		query.append("                 #if ($cntr_no.length() == 10) " ).append("\n"); 
		query.append("                 AND   A.CNTR_NO LIKE @[cntr_no] || '%'" ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("                 ##${cntr_no}" ).append("\n"); 
		query.append("                 #if ($cntr_no.length() != 10) " ).append("\n"); 
		query.append("                 AND   A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("                 AND CNMV_DT = (" ).append("\n"); 
		query.append("                               SELECT MAX(CNMV_DT) " ).append("\n"); 
		query.append("                               FROM MST_CONTAINER " ).append("\n"); 
		query.append("                               WHERE 1 = 1" ).append("\n"); 
		query.append("                               ##${cntr_no}" ).append("\n"); 
		query.append("                               #if ($cntr_no.length() == 10) " ).append("\n"); 
		query.append("                               AND   CNTR_NO LIKE @[cntr_no] || '%'" ).append("\n"); 
		query.append("                               #end " ).append("\n"); 
		query.append("                               ##${cntr_no}" ).append("\n"); 
		query.append("                               #if ($cntr_no.length() != 10) " ).append("\n"); 
		query.append("                               AND   CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                               #end " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                 AND ROWNUM = 1 " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CM.CNMV_YR    = @[cnmv_yr]" ).append("\n"); 
		query.append("AND CM.CNMV_ID_NO = @[cnmv_id_no]" ).append("\n"); 
		query.append("AND ROWNUM        = 1" ).append("\n"); 

	}
}