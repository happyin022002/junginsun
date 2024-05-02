/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ConstraintManageDBDAOCheckPsLinkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.22
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2012.03.22 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintManageDBDAOCheckPsLinkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckPsLink
	  * </pre>
	  */
	public ConstraintManageDBDAOCheckPsLinkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_cnst_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration").append("\n"); 
		query.append("FileName : ConstraintManageDBDAOCheckPsLinkRSQL").append("\n"); 
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
		query.append("SELECT  'X' " ).append("\n"); 
		query.append("FROM PRD_LNK_CNST_MGMT " ).append("\n"); 
		query.append("WHERE LNK_ORG_NOD_CD = @[lnk_org_nod_cd] " ).append("\n"); 
		query.append("AND LNK_DEST_NOD_CD = @[lnk_dest_nod_cd] " ).append("\n"); 
		query.append("AND TRSP_MOD_CD = @[trsp_mod_cd] " ).append("\n"); 
		query.append("AND LNK_CNST_ITM_CD = @[lnk_cnst_itm_cd] " ).append("\n"); 
		query.append("AND NVL(CMDT_CD,'N') = NVL(@[cmdt_cd],'N')" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(VSL_SLAN_CD, ' ') = NVL(@[vsl_slan_cd], ' ')" ).append("\n"); 
		query.append("AND NVL(VSL_CD, ' ')     = NVL(SUBSTR(@[vvd],1,4), ' ')" ).append("\n"); 
		query.append("AND NVL(SKD_VOY_NO, ' ') = NVL(SUBSTR(@[vvd],5,4), ' ')" ).append("\n"); 
		query.append("AND NVL(SKD_DIR_CD, ' ') = NVL(SUBSTR(@[vvd],9,1), ' ')" ).append("\n"); 

	}
}