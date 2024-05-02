/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOCheckSdmsDeletePossRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.29
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOCheckSdmsDeletePossRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SDMS를 지울수 있는지 확인
	  * 
	  * 2010.11.29 이상민 CSR예정
	  * 제목:SDMS 삭제 관련 처리 로직
	  * 쿼리 수정 후 반영
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOCheckSdmsDeletePossRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOCheckSdmsDeletePossRSQL").append("\n"); 
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
		query.append("SELECT  CASE WHEN SDMS_DELT_FLG = 'DELETE_POSSIBLE'    THEN 0" ).append("\n"); 
		query.append("             WHEN SDMS_DELT_FLG = 'DELETE_IMPOSSIBLE'  THEN 1" ).append("\n"); 
		query.append("        END  KNT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT        MST.STV_DMG_NO" ).append("\n"); 
		query.append("                ,     DTL.STV_DMG_REQ_CATE_CD" ).append("\n"); 
		query.append("                ,     RPR.STV_DMG_RPR_PROC_STS_CD" ).append("\n"); 
		query.append("                ,     CMP.STV_DMG_CMPN_PROC_STS_CD" ).append("\n"); 
		query.append("                ,     STL.STV_DMG_STL_PROC_STS_CD" ).append("\n"); 
		query.append("                ,     CASE WHEN     STL.STV_DMG_STL_PROC_STS_CD   = 'P'                /* P : Paid */" ).append("\n"); 
		query.append("                                OR  RPR.STV_DMG_RPR_PROC_STS_CD   IN ('O','R','C','Q') THEN 'DELETE_IMPOSSIBLE'" ).append("\n"); 
		query.append("                                    /* O : Ordered " ).append("\n"); 
		query.append("                                       R : Reparing" ).append("\n"); 
		query.append("                                       C : Completed" ).append("\n"); 
		query.append("                                       Q : Quoted" ).append("\n"); 
		query.append("                                    */" ).append("\n"); 
		query.append("                           WHEN     RPR.STV_DMG_RPR_PROC_STS_CD   IS NULL " ).append("\n"); 
		query.append("                                AND CMP.STV_DMG_CMPN_PROC_STS_CD  IS NULL" ).append("\n"); 
		query.append("                                AND STL.STV_DMG_STL_PROC_STS_CD   IS NULL              THEN 'DELETE_POSSIBLE'" ).append("\n"); 
		query.append("                           ELSE                                                             'DELETE_IMPOSSIBLE'" ).append("\n"); 
		query.append("                      END  AS SDMS_DELT_FLG" ).append("\n"); 
		query.append("        FROM          OPF_STV_DMG                        MST" ).append("\n"); 
		query.append("                ,     OPF_STV_DMG_DTL                    DTL" ).append("\n"); 
		query.append("                ,     OPF_STV_DMG_RPR                    RPR" ).append("\n"); 
		query.append("                ,     OPF_STV_DMG_CMPN                   CMP" ).append("\n"); 
		query.append("                ,     OPF_STV_DMG_STL                    STL" ).append("\n"); 
		query.append("        WHERE         MST.STV_DMG_NO                     = DTL.STV_DMG_NO (+)" ).append("\n"); 
		query.append("        AND           MST.STV_DMG_NO                     = RPR.STV_DMG_NO (+)" ).append("\n"); 
		query.append("        AND           MST.STV_DMG_NO                     = CMP.STV_DMG_NO (+)" ).append("\n"); 
		query.append("        AND           MST.STV_DMG_NO                     = STL.STV_DMG_NO (+)" ).append("\n"); 
		query.append("        AND           MST.STV_DMG_NO                     = @[stv_dmg_no]    " ).append("\n"); 
		query.append("        )    " ).append("\n"); 

	}
}