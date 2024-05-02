/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ReplanManageDBDAOSearchNewSORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.17
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.05.17 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOSearchNewSORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 대상조회
	  * </pre>
	  */
	public ReplanManageDBDAOSearchNewSORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration ").append("\n"); 
		query.append("FileName : ReplanManageDBDAOSearchNewSORSQL").append("\n"); 
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
		query.append("SELECT C.CNTR_NO  CNTR_NO" ).append("\n"); 
		query.append(", C.CNMV_YR  CNMV_YR" ).append("\n"); 
		query.append(", C.CNMV_ID_NO CNMV_ID_NO" ).append("\n"); 
		query.append(", C.CLM_SEQ  CLM_SEQ" ).append("\n"); 
		query.append("FROM TRS_TRSP_RAIL_BIL_ORD A" ).append("\n"); 
		query.append(", SCE_CLM C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("FROM TRS_TRSP_RAIL_BIL_ORD B" ).append("\n"); 
		query.append("WHERE (B.TRSP_SO_OFC_CTY_CD,B.TRSP_SO_SEQ) = ((@[trsp_so_ofc_cty_cd],@[trsp_so_seq]))" ).append("\n"); 
		query.append("AND A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("AND A.FM_NOD_CD = B.FM_NOD_CD" ).append("\n"); 
		query.append("AND A.TO_NOD_CD = B.TO_NOD_CD )" ).append("\n"); 
		query.append("AND A.EQ_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND (A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ) = ((C.TRSP_SO_OFC_CTY_CD,C.TRSP_SO_SEQ))" ).append("\n"); 

	}
}