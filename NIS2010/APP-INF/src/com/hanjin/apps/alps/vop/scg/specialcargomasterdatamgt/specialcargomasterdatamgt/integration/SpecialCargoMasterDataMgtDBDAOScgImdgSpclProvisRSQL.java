/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOScgImdgSpclProvisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.11.04 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOScgImdgSpclProvisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * d
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOScgImdgSpclProvisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_tbl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOScgImdgSpclProvisRSQL").append("\n"); 
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
		query.append("SELECT   S.IMDG_UN_NO," ).append("\n"); 
		query.append("S.IMDG_UN_NO_SEQ," ).append("\n"); 
		query.append("S.PRP_SHP_NM," ).append("\n"); 
		query.append("S.IMDG_CLSS_CD," ).append("\n"); 
		query.append("CASE WHEN S.IMDG_PCK_GRP_CD='1' THEN  'I'" ).append("\n"); 
		query.append("WHEN S.IMDG_PCK_GRP_CD='2' THEN  'II'" ).append("\n"); 
		query.append("WHEN S.IMDG_PCK_GRP_CD='3' THEN  'III'  END IMDG_PCK_GRP_CD," ).append("\n"); 
		query.append("''CRE_USR_ID," ).append("\n"); 
		query.append("''CRE_DT," ).append("\n"); 
		query.append("''UPD_USR_ID," ).append("\n"); 
		query.append("''UPD_DT," ).append("\n"); 
		query.append("S.IMDG_TBL_NO," ).append("\n"); 
		query.append("NVL(MAX(CASE  WHEN S.RN = 1 THEN S.IMDG_SUBS_RSK_LBL_CD  END),'')||" ).append("\n"); 
		query.append("NVL(MAX(CASE  WHEN S.RN = 2 THEN '/'||S.IMDG_SUBS_RSK_LBL_CD  END),'')||" ).append("\n"); 
		query.append("NVL(MAX(CASE  WHEN S.RN = 3 THEN '/'||S.IMDG_SUBS_RSK_LBL_CD  END),'')||" ).append("\n"); 
		query.append("NVL(MAX(CASE  WHEN S.RN = 4 THEN '/'||S.IMDG_SUBS_RSK_LBL_CD  END),'')  IMDG_SUBS_RSK_LBL_CD_1" ).append("\n"); 
		query.append("FROM ( SELECT" ).append("\n"); 
		query.append("A.IMDG_UN_NO," ).append("\n"); 
		query.append("A.IMDG_UN_NO_SEQ," ).append("\n"); 
		query.append("A.PRP_SHP_NM," ).append("\n"); 
		query.append("A.IMDG_CLSS_CD," ).append("\n"); 
		query.append("A.IMDG_PCK_GRP_CD," ).append("\n"); 
		query.append("B.IMDG_SUBS_RSK_LBL_CD,A.IMDG_TBL_NO," ).append("\n"); 
		query.append("ROW_NUMBER()OVER(PARTITION BY A.IMDG_UN_NO,A.IMDG_UN_NO_SEQ ORDER BY  IMDG_SUBS_RSK_LBL_CD) RN" ).append("\n"); 
		query.append("FROM   SCG_IMDG_UN_NO A, SCG_IMDG_SUBS_RSK_LBL B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.IMDG_UN_NO     = B.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("AND   A.IMDG_UN_NO_SEQ = B.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${imdg_tbl_no} != '')" ).append("\n"); 
		query.append("AND   A.IMDG_TBL_NO    = @[imdg_tbl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_un_no} != '' )" ).append("\n"); 
		query.append("AND   A.IMDG_UN_NO     = @[imdg_un_no]" ).append("\n"); 
		query.append("AND   A.IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") S" ).append("\n"); 
		query.append("GROUP BY   S.IMDG_UN_NO," ).append("\n"); 
		query.append("S.IMDG_UN_NO_SEQ," ).append("\n"); 
		query.append("S.PRP_SHP_NM," ).append("\n"); 
		query.append("S.IMDG_CLSS_CD," ).append("\n"); 
		query.append("S.IMDG_PCK_GRP_CD,S.IMDG_TBL_NO" ).append("\n"); 
		query.append("ORDER BY S.IMDG_UN_NO, S.IMDG_UN_NO_SEQ" ).append("\n"); 

	}
}