/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PrdCreateManageDBDAOUpdateActivityGroupUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateManageDBDAOUpdateActivityGroupUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PrdCreateManageDBDAOUpdateActivityGroupUSQL
	  * </pre>
	  */
	public PrdCreateManageDBDAOUpdateActivityGroupUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.common.prdcreate.integration").append("\n"); 
		query.append("FileName : PrdCreateManageDBDAOUpdateActivityGroupUSQL").append("\n"); 
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
		query.append("--eNIS용소스" ).append("\n"); 
		query.append("UPDATE PRD_PROD_CTL_ACT_GRP_DTL D" ).append("\n"); 
		query.append("SET D.COST_ACT_GRP_CD = DECODE(D.COST_ACT_GRP_TP_CD,'N','DMND','DMLK')" ).append("\n"); 
		query.append("WHERE D.PCTL_NO LIKE @[hd_pctl_no]||'%'" ).append("\n"); 
		query.append("AND D.PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("AND (D.COST_ACT_GRP_TP_CD ='N'" ).append("\n"); 
		query.append("OR (" ).append("\n"); 
		query.append("D.COST_ACT_GRP_TP_CD ='L'" ).append("\n"); 
		query.append("AND SUBSTR(D.N1ST_NOD_CD,1,5) = SUBSTR(D.N2ND_NOD_CD,1,5)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND EXISTS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'X' FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DTL.PCTL_NO," ).append("\n"); 
		query.append("(CASE WHEN LEAD (DTL.SKD_VOY_NO||DTL.SKD_DIR_CD,1,NULL) OVER (PARTITION BY DTL.PCTL_NO ORDER BY DTL.PCTL_SEQ) = V.TURN_SKD_VOY_NO||V.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("AND LEAD (DTL.VSL_CD,1,NULL) OVER (PARTITION BY DTL.PCTL_NO ORDER BY DTL.PCTL_SEQ) = DTL.VSL_CD" ).append("\n"); 
		query.append("THEN SUBSTR(DTL.DEST_NOD_CD,1,5)" ).append("\n"); 
		query.append("END) NO_COST" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL DTL , VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE DTL.PCTL_NO LIKE @[hd_pctl_no]||'%'" ).append("\n"); 
		query.append("AND DTL.PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("AND DTL.NOD_LNK_DIV_CD ='L'" ).append("\n"); 
		query.append("AND DTL.TRSP_MOD_CD = 'VD'" ).append("\n"); 
		query.append("AND DTL.VSL_CD=V.VSL_CD" ).append("\n"); 
		query.append("AND DTL.SKD_VOY_NO=V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND DTL.SKD_DIR_CD=V.SKD_DIR_CD" ).append("\n"); 
		query.append("AND SUBSTR(DTL.DEST_NOD_CD,1,5) = V.VPS_PORT_CD" ).append("\n"); 
		query.append("AND DTL.DEST_CLPT_IND_SEQ = V.CLPT_IND_SEQ" ).append("\n"); 
		query.append(") CHK" ).append("\n"); 
		query.append("WHERE CHK.NO_COST IS NOT NULL" ).append("\n"); 
		query.append("AND CHK.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("AND SUBSTR(D.N1ST_NOD_CD,1,5) = CHK.NO_COST" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}