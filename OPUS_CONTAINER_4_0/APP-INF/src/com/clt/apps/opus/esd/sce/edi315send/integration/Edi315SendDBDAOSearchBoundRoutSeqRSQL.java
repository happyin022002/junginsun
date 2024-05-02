/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi315SendDBDAOSearchBoundRoutSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.10.01 전병석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun Byoung Suk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchBoundRoutSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for search bound rout seq
	  * </pre>
	  */
	public Edi315SendDBDAOSearchBoundRoutSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchBoundRoutSeqRSQL").append("\n"); 
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
		query.append("select DISTINCT ROUT_SEQ, ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("from sce_cop_hdr h, prd_prod_ctl_rout_dtl p" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("and h.cop_no = @[e_cop_no]" ).append("\n"); 
		query.append("and h.pctl_no = p.pctl_no" ).append("\n"); 
		query.append("and p.pctl_io_bnd_cd = 'I'" ).append("\n"); 
		query.append("and rownum= 1" ).append("\n"); 

	}
}