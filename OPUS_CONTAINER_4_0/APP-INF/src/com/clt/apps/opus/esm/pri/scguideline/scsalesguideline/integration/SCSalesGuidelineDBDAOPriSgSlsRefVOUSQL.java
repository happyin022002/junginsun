/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.04.30 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scsalesguideline.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sungsoo
 * @see 
 * @since J2EE 1.4
 */

public class SCSalesGuidelineDBDAOPriSgSlsRefVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCSalesGuideline 수정
	  * </pre>
	  */
	public SCSalesGuidelineDBDAOPriSgSlsRefVOUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "2,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "91,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_tit_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "2,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("UPDATE pri_sg_sls_ref SET" ).append("\n"); 
		query.append("ref_tit_nm = @[ref_tit_nm]," ).append("\n"); 
		query.append("ref_ctnt = @[ref_ctnt]," ).append("\n"); 
		query.append("upd_usr_id = @[upd_usr_id]," ).append("\n"); 
		query.append("upd_dt = sysdate" ).append("\n"); 
		query.append("WHERE svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND gline_seq = @[gline_seq]" ).append("\n"); 
		query.append("AND ref_seq = @[ref_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scguideline.scsalesguideline.integration").append("\n"); 
		query.append("FileName : SCSalesGuidelineDBDAOPriSgSlsRefVOUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}