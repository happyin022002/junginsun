/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOCheckVoyageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.07
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.05.07 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOCheckVoyageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 이전 버전의 End VVD의 Voyage와 신규입력, 수정하는 데이터의  Start VVD의 Voyage를 비교하여 순서에 맞는지를 확인함. 
	  * Start VVD와  End VVD 간의 선후관계도  check.함.
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOCheckVoyageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_st_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_end_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_jo_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOCheckVoyageRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("#if (${old_jo_ver_no} == '0')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   CASE WHEN TO_NUMBER(@[jo_st_skd_voy_no])> TO_NUMBER(@[jo_end_skd_voy_no])" ).append("\n"); 
		query.append("       THEN 'N'" ).append("\n"); 
		query.append("       ELSE 'Y'" ).append("\n"); 
		query.append("       END  AS VOY_CHK   " ).append("\n"); 
		query.append(" FROM  DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${jo_st_skd_voy_no} != '' && ${jo_end_skd_voy_no} != '' ) " ).append("\n"); 
		query.append("   CASE WHEN ( TO_NUMBER(A.JO_END_SKD_VOY_NO) >= TO_NUMBER(@[jo_st_skd_voy_no]) OR (TO_NUMBER(@[jo_st_skd_voy_no])> TO_NUMBER(@[jo_end_skd_voy_no])))" ).append("\n"); 
		query.append("       THEN 'N'" ).append("\n"); 
		query.append("       ELSE 'Y'" ).append("\n"); 
		query.append("       END  AS VOY_CHK   " ).append("\n"); 
		query.append("#elseif (${jo_st_skd_voy_no} != '' && ${jo_end_skd_voy_no} == '' ) " ).append("\n"); 
		query.append("   CASE WHEN  TO_NUMBER( A.JO_END_SKD_VOY_NO) >= TO_NUMBER(@[jo_st_skd_voy_no])" ).append("\n"); 
		query.append("        THEN 'N'" ).append("\n"); 
		query.append("        ELSE 'Y'" ).append("\n"); 
		query.append("        END  AS VOY_CHK " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(" 'Y' AS VOY_CHK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  FROM  JOO_BSA_INFO_ENTR A" ).append("\n"); 
		query.append(" WHERE   A.VSL_CD     =  @[vsl_cd]       " ).append("\n"); 
		query.append("   AND   A.SKD_DIR_CD =  @[skd_dir_cd]   " ).append("\n"); 
		query.append("   AND   A.PORT_CD    =  @[port_cd]      " ).append("\n"); 
		query.append("   AND   A.PORT_SEQ   =  @[port_seq]     " ).append("\n"); 
		query.append("   AND   A.JO_CRR_CD  =  @[jo_crr_cd]    " ).append("\n"); 
		query.append("   AND   A.JO_VER_NO  =  @[old_jo_ver_no]" ).append("\n"); 
		query.append("   AND   A.RLANE_CD   =  @[rlane_cd]" ).append("\n"); 
		query.append("   AND   A.JO_VER_FLG = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}