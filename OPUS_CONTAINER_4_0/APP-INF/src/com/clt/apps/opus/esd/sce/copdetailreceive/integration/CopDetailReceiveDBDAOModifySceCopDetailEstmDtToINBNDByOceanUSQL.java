/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOModifySceCopDetailEstmDtToINBNDByOceanUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.10 
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

public class CopDetailReceiveDBDAOModifySceCopDetailEstmDtToINBNDByOceanUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifySceCopDetailEstmDtToINBNDByOcean
	  * </pre>
	  */
	public CopDetailReceiveDBDAOModifySceCopDetailEstmDtToINBNDByOceanUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_evnt_gap_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOModifySceCopDetailEstmDtToINBNDByOceanUSQL").append("\n"); 
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
		query.append("update sce_cop_dtl" ).append("\n"); 
		query.append("set    estm_dt     = estm_dt + @[rcv_evnt_gap_desc]" ).append("\n"); 
		query.append(",estm_gdt    = globaldate_pkg.time_conv_fnc(substr(nod_cd,1,5), estm_dt + @[rcv_evnt_gap_desc], 'GMT')" ).append("\n"); 
		query.append(",upd_usr_id  = 'VPS_IB'" ).append("\n"); 
		query.append(",upd_dt      = sysdate" ).append("\n"); 
		query.append("where  cop_no      = @[cop_no]" ).append("\n"); 
		query.append("and    (cop_no||cop_dtl_seq) > (@[cop_no]||@[fm_cop_dtl_seq])" ).append("\n"); 

	}
}