/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAORemoveSOCandidateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.03.16 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAORemoveSOCandidateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Candidate Delete 대상을 조회 (LCL Master/Slave 모두 조회)
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAORemoveSOCandidateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trunkvvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAORemoveSOCandidateRSQL").append("\n"); 
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
		query.append("SELECT  B.COP_NO" ).append("\n"); 
		query.append(",B.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append(",A.BKG_NO" ).append("\n"); 
		query.append("FROM SCE_COP_HDR A," ).append("\n"); 
		query.append("SCE_PLN_SO_LIST B," ).append("\n"); 
		query.append("BKG_BOOKING C" ).append("\n"); 
		query.append("WHERE A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND A.CNTR_NO     = @[eq_no]" ).append("\n"); 
		query.append("AND C.POL_CD      = @[pol_cd]" ).append("\n"); 
		query.append("AND A.TRNK_VSL_CD = SUBSTR(@[trunkvvd],1,4)" ).append("\n"); 
		query.append("AND A.TRNK_SKD_VOY_NO = SUBSTR(@[trunkvvd],5,4)" ).append("\n"); 
		query.append("AND A.TRNK_SKD_DIR_CD = SUBSTR(@[trunkvvd],9,1)" ).append("\n"); 
		query.append("AND A.COP_STS_CD NOT IN ('X', 'O')" ).append("\n"); 
		query.append("AND B.TRSP_SO_STS_CD in ( 'P')" ).append("\n"); 
		query.append("AND B.CTRL_OFC_CD = @[ctrl_ofc_cd]" ).append("\n"); 
		query.append("AND B.N1ST_NOD_CD = @[fm_nod_cd]||@[fm_nod_yard]" ).append("\n"); 
		query.append("AND A.CNTR_NO <> 'SMCU0000000'" ).append("\n"); 
		query.append("AND NVL2(A.MST_COP_NO, 'P', 'X') = 'X' -- LCL CNTR중 Slave건만 조회한다." ).append("\n"); 

	}
}