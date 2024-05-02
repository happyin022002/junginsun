/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOModifyRailSOByMVMTUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009.09.09 김성일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungil Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOModifyRailSOByMVMTUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyRailSOByMVMT
	  * </pre>
	  */
	public CopDetailReceiveDBDAOModifyRailSOByMVMTUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("v_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOModifyRailSOByMVMTUSQL").append("\n"); 
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
		query.append("MERGE INTO  TRS_TRSP_RAIL_BIL_ORD  D" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("USING ( SELECT A.TRSP_SO_OFC_CTY_CD,A.TRSP_SO_SEQ,A.COP_NO, A.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("FROM   TRS_TRSP_RAIL_BIL_ORD A" ).append("\n"); 
		query.append("WHERE  A.COP_NO      = @[v_cop_no]" ).append("\n"); 
		query.append("AND    A.TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("AND    A.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("GROUP BY A.TRSP_SO_OFC_CTY_CD,A.TRSP_SO_SEQ,A.COP_NO, A.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append(") S" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ON    ( D.TRSP_SO_OFC_CTY_CD = S.TRSP_SO_OFC_CTY_CD AND D.TRSP_SO_SEQ = S.TRSP_SO_SEQ )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN UPDATE SET  D.TML_NOD_CD = @[in_nod_cd]" ).append("\n"); 
		query.append(",D.VD_DT      = TO_DATE(@[in_act_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append(",D.LOG_UPD_DT = SYSDATE" ).append("\n"); 

	}
}