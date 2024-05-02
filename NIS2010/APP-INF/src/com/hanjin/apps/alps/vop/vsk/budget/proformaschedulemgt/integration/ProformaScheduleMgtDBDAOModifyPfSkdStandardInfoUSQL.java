/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOModifyPfSkdStandardInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.22 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOModifyPfSkdStandardInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSK_PF_SKD 테이블에 변경된 P/F Schedule 정보를 변경한다.
	  * 
	  * * History
	  * * 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOModifyPfSkdStandardInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pf_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOModifyPfSkdStandardInfoUSQL").append("\n"); 
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
		query.append("##${pfCount}" ).append("\n"); 
		query.append("#if ($pfCount > 1)" ).append("\n"); 
		query.append("UPDATE	VSK_BUD_PF_SKD" ).append("\n"); 
		query.append("SET	SLAN_STND_FLG		= 'N'," ).append("\n"); 
		query.append("	UPD_USR_ID			= @[upd_usr_id]," ).append("\n"); 
		query.append("	UPD_DT				= SYSDATE" ).append("\n"); 
		query.append("WHERE	VSL_SLAN_CD		= @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND		PF_SVC_TP_CD	<> @[pf_svc_tp_cd]" ).append("\n"); 
		query.append("AND		SLAN_STND_FLG	= 'Y'" ).append("\n"); 
		query.append("AND     DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($pfCount == 0)" ).append("\n"); 
		query.append("UPDATE	VSK_BUD_PF_SKD" ).append("\n"); 
		query.append("SET		SLAN_STND_FLG		= 'Y'," ).append("\n"); 
		query.append("		UPD_USR_ID			= @[upd_usr_id]," ).append("\n"); 
		query.append("		UPD_DT				= SYSDATE" ).append("\n"); 
		query.append("WHERE	VSL_SLAN_CD		= @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND	PF_SVC_TP_CD		= @[pf_svc_tp_cd]" ).append("\n"); 
		query.append("AND     DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}