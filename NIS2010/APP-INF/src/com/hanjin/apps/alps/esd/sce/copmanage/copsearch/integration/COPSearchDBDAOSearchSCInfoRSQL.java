/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COPSearchDBDAOSearchSCInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.10.23 오현경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Oh hyun-kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPSearchDBDAOSearchSCInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cop inquiry
	  * </pre>
	  */
	public COPSearchDBDAOSearchSCInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration").append("\n"); 
		query.append("FileName : COPSearchDBDAOSearchSCInfoRSQL").append("\n"); 
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
		query.append("SELECT grp.cop_no" ).append("\n"); 
		query.append(", trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append(", trsp_so_seq" ).append("\n"); 
		query.append(", bkg_no" ).append("\n"); 
		query.append("FROM trs_trsp_svc_ord grp" ).append("\n"); 
		query.append(",sce_cop_hdr hdr" ).append("\n"); 
		query.append("WHERE grp.cop_no = hdr.cop_no" ).append("\n"); 
		query.append("AND grp.cop_no = @[old_cop_no]" ).append("\n"); 
		query.append("AND NVL(trsp_so_ofc_cty_cd,' ')  <> ' '" ).append("\n"); 
		query.append("AND NVL(trsp_so_ofc_cty_cd,' ')  <> 'P'" ).append("\n"); 
		query.append("AND NVL(TO_CHAR(trsp_so_seq),' ') <> ' '" ).append("\n"); 

	}
}