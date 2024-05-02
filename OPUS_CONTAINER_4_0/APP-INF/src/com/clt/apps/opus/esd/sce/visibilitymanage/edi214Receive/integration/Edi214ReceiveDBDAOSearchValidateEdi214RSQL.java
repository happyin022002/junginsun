/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi214ReceiveDBDAOSearchValidateEdi214RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.12.01 이중환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.visibilitymanage.edi214Receive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Joong Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi214ReceiveDBDAOSearchValidateEdi214RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select validate
	  * </pre>
	  */
	public Edi214ReceiveDBDAOSearchValidateEdi214RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.visibilitymanage.edi214Receive.integration").append("\n"); 
		query.append("FileName : Edi214ReceiveDBDAOSearchValidateEdi214RSQL").append("\n"); 
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
		query.append("SELECT d.COP_DTL_SEQ COP_DTL_SEQ, d.COP_NO COP_NO" ).append("\n"); 
		query.append("FROM sce_cop_dtl d, (" ).append("\n"); 
		query.append("select cop_no,DOR_NOD_CD  from trs_trsp_svc_ord" ).append("\n"); 
		query.append("where TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("and TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("and BKG_RCVDE_TERM_CD = 'D'" ).append("\n"); 
		query.append(") v" ).append("\n"); 
		query.append("WHERE d.COP_NO = v.cop_no" ).append("\n"); 
		query.append("and d.act_cd = 'FITZAD'" ).append("\n"); 
		query.append("and d.NOD_CD = v.DOR_NOD_CD" ).append("\n"); 

	}
}