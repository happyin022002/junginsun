/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InlandLinkManageDBDAOValidationVendorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.30
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2010.09.30 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandLinkManageDBDAOValidationVendorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ValidationVendor
	  * </pre>
	  */
	public InlandLinkManageDBDAOValidationVendorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chkData",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.integration").append("\n"); 
		query.append("FileName : InlandLinkManageDBDAOValidationVendorRSQL").append("\n"); 
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
		query.append("SELECT M.VNDR_SEQ, M.VNDR_ABBR_NM comData1, VNDR_LGL_ENG_NM comData2" ).append("\n"); 
		query.append("FROM TRS_AGMT_HDR H, TRS_AGMT_APLY_VNDR V, TRS_AGMT_EQ_RT R, MDM_VENDOR M" ).append("\n"); 
		query.append("WHERE H.TRSP_AGMT_OFC_CTY_CD = V.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   H.TRSP_AGMT_SEQ        = V.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("AND   H.TRSP_AGMT_OFC_CTY_CD = R.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   H.TRSP_AGMT_SEQ        = R.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("AND   NVL(V.DELT_FLG, 'N')   = 'N'" ).append("\n"); 
		query.append("AND   V.VNDR_SEQ             = M.VNDR_SEQ" ).append("\n"); 
		query.append("AND   V.VNDR_SEQ             = @[chkData]" ).append("\n"); 
		query.append("AND   NVL(M.DELT_FLG, 'N')   = 'N'" ).append("\n"); 
		query.append("AND   SYSDATE BETWEEN R.EFF_FM_DT AND R.EFF_TO_DT" ).append("\n"); 
		query.append("AND   ROWNUM                 = 1" ).append("\n"); 

	}
}