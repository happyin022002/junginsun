/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.23
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.23 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see 
 * @since J2EE 1.4
 */

public class SCGroupCommodityGuidelineDBDAOMaxGrpLocSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GRP_CMDT_SEQ의 max+1 값
	  * </pre>
	  */
	public SCGroupCommodityGuidelineDBDAOMaxGrpLocSeqRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT" ).append("\n"); 
		query.append("NVL((SELECT /*+ INDEX_DESC(a XPKPRI_SG_GRP_CMDT) */" ).append("\n"); 
		query.append("grp_cmdt_seq" ).append("\n"); 
		query.append("FROM pri_sg_grp_cmdt a" ).append("\n"); 
		query.append("WHERE svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND gline_seq = @[gline_seq]" ).append("\n"); 
		query.append("AND prc_cust_tp_cd = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("AND rownum = 1), 0) + 1 AS next_seq" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}