/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOmodifyWOFileListByIssueDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOmodifyWOFileListByIssueDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 동일한 Service Provider에 이미 입력되었는데 아직 Invoice로 처리되지 않은 내역체크
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOmodifyWOFileListByIssueDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_dtl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOmodifyWOFileListByIssueDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_DAT_VRFY A" ).append("\n"); 
		query.append("SET INP_MSG4 = 'AS'" ).append("\n"); 
		query.append("WHERE A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND   A.INP_MSG4 = 'SS'" ).append("\n"); 
		query.append("AND  (A.TMP_SEQ,A.TMP_DTL_SEQ) IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT MDV.TMP_SEQ,MDV.TMP_DTL_SEQ" ).append("\n"); 
		query.append("FROM MNR_DAT_VRFY MDV,MNR_ORD_DTL MOD, MNR_ORD_HDR MOH" ).append("\n"); 
		query.append("WHERE MOD.MNR_ORD_OFC_CTY_CD = MOH.MNR_ORD_OFC_CTY_CD " ).append("\n"); 
		query.append("  AND MOD.MNR_ORD_SEQ = MOH.MNR_ORD_SEQ " ).append("\n"); 
		query.append("  AND MOD.PAY_INV_SEQ IS NULL" ).append("\n"); 
		query.append("  AND MDV.INP_MSG4 = 'SS'" ).append("\n"); 
		query.append("  AND MDV.INP_MSG1 = MOD.EQ_NO(+)" ).append("\n"); 
		query.append("  AND MDV.TMP_SEQ = @[tmp_seq] " ).append("\n"); 
		query.append("  AND MOH.EQ_KND_CD = @[eq_type]" ).append("\n"); 
		query.append("  AND MOH.COST_CD   =  @[cost_cd]" ).append("\n"); 
		query.append("  AND MOH.VNDR_SEQ  =  @[vndr_seq]" ).append("\n"); 
		query.append("  AND MOD.COST_DTL_CD = @[cost_dtl_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}