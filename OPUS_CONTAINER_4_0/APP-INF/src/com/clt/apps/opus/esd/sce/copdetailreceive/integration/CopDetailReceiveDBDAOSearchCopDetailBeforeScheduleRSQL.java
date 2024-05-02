/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchCopDetailBeforeScheduleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchCopDetailBeforeScheduleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCopDetailBeforeSchedule
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchCopDetailBeforeScheduleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchCopDetailBeforeScheduleRSQL").append("\n"); 
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
		query.append("SELECT act_cd" ).append("\n"); 
		query.append(", TO_CHAR(ESTM_DT,'YYYY/MM/DD HH24:MI:SS') bfr_estm_dt" ).append("\n"); 
		query.append(", TO_CHAR(ACT_DT,'YYYY/MM/DD HH24:MI:SS') bfr_act_dt" ).append("\n"); 
		query.append(", nod_cd" ).append("\n"); 
		query.append(", vsl_cd" ).append("\n"); 
		query.append(", skd_voy_no" ).append("\n"); 
		query.append(", skd_dir_cd" ).append("\n"); 
		query.append(", vps_port_cd clpt_cd" ).append("\n"); 
		query.append(", clpt_ind_seq" ).append("\n"); 
		query.append(", edi_msg_tp_cd" ).append("\n"); 
		query.append("FROM   SCE_COP_DTL" ).append("\n"); 
		query.append("WHERE  COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND    COP_DTL_SEQ = @[cop_dtl_seq]" ).append("\n"); 

	}
}