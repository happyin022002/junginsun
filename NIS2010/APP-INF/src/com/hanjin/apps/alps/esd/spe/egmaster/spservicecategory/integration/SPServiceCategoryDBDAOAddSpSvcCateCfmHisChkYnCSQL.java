/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SPServiceCategoryDBDAOAddSpSvcCateCfmHisChkYnCSQL.java
*@FileTitle : Terminal Productivity Target Input
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.16
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.16 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPServiceCategoryDBDAOAddSpSvcCateCfmHisChkYnCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 업체의 서비스 카테고리 정보를 사용자가 선택을 안한경우 히스토리 테이블에 체크안함으로 저장한다
	  * </pre>
	  */
	public SPServiceCategoryDBDAOAddSpSvcCateCfmHisChkYnCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_grp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.integration").append("\n"); 
		query.append("FileName : SPServiceCategoryDBDAOAddSpSvcCateCfmHisChkYnCSQL").append("\n"); 
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
		query.append("INSERT INTO SPE_SP_SVC_CATE_STUP_HIS(SP_SEQ" ).append("\n"); 
		query.append("                                   , EV_SVC_CATE_CD" ).append("\n"); 
		query.append("                                   , SP_SVC_CATE_HIS_SEQ" ).append("\n"); 
		query.append("                                   , SP_RGN_GRP_OFC_CD" ).append("\n"); 
		query.append("                                   , SP_CTRL_OFC_CD" ).append("\n"); 
		query.append("                                   , SP_CTRT_OFC_CD" ).append("\n"); 
		query.append("                                   , INP_DT" ).append("\n"); 
		query.append("                                   , DELT_FLG" ).append("\n"); 
		query.append("                                   , CHK_FLG" ).append("\n"); 
		query.append("                                   , CRE_USR_ID" ).append("\n"); 
		query.append("                                   , CRE_DT" ).append("\n"); 
		query.append("                                   , UPD_USR_ID" ).append("\n"); 
		query.append("                                   , UPD_DT" ).append("\n"); 
		query.append("                                  )VALUES(" ).append("\n"); 
		query.append("                                     @[sp_seq]" ).append("\n"); 
		query.append("                                   , ' '" ).append("\n"); 
		query.append("                                   , (SELECT COUNT(1)+1 FROM SPE_SP_SVC_CATE_STUP_HIS WHERE SP_SEQ = @[sp_seq] AND EV_SVC_CATE_CD = NVL('',' '))" ).append("\n"); 
		query.append("                                   , @[sp_grp_ofc_cd]" ).append("\n"); 
		query.append("                                   , @[sp_ctrl_ofc_cd]" ).append("\n"); 
		query.append("                                   , @[sp_ctrt_ofc_cd]" ).append("\n"); 
		query.append("                                   , TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("                                   , 'N'" ).append("\n"); 
		query.append("                                   , 'Y'" ).append("\n"); 
		query.append("                                   , @[cre_usr_id]" ).append("\n"); 
		query.append("                                   , SYSDATE" ).append("\n"); 
		query.append("                                   , @[upd_usr_id]" ).append("\n"); 
		query.append("                                   , SYSDATE" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 

	}
}