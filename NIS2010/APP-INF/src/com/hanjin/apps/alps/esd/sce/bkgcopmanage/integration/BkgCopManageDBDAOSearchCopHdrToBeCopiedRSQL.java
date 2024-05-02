/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchCopHdrToBeCopiedRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.07
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.05.07 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchCopHdrToBeCopiedRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 지정된 bkg_no 와 cop_sts_cd 를 바탕으로 기 존재하는 COP 를 copy 하여 재 생성할 정보를 조회한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchCopHdrToBeCopiedRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_upd_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchCopHdrToBeCopiedRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'C'|| (case when H.bkg_ofc_cd is not null then SUBSTR(H.bkg_ofc_cd,1,3) else" ).append("\n"); 
		query.append("case when C.bkg_ofc_cd is null then SUBSTR(@[bkg_no] ,1,3 ) else SUBSTR(C.bkg_ofc_cd, 1,3) end" ).append("\n"); 
		query.append("end) ||" ).append("\n"); 
		query.append("SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),2,1) ||                                             --2007-04-30:jsahn:cop sequence 변경 Y(1)" ).append("\n"); 
		query.append("CASE WHEN SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),3,2) = '10' THEN 'A'                      --20070430" ).append("\n"); 
		query.append("WHEN SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),3,2) = '11' THEN 'B'                      --20070430" ).append("\n"); 
		query.append("WHEN SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),3,2) = '12' THEN 'C'                      --20070430" ).append("\n"); 
		query.append("ELSE SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),4,1)                                      --20070430 M(1)" ).append("\n"); 
		query.append("END  ||                                                                              --20070430" ).append("\n"); 
		query.append("SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),5,2) ||                                             --20070430 D(2)" ).append("\n"); 
		query.append("TRIM(TO_CHAR(SCE_COP_SEQ1.NEXTVAL,'000000'))                                         --20070430 SEQ(6)" ).append("\n"); 
		query.append("as COP_NO," ).append("\n"); 
		query.append("A.COP_NO AS ORG_COP_NO," ).append("\n"); 
		query.append("A.BKG_NO                      ," ).append("\n"); 
		query.append("CNTR_NO                     ," ).append("\n"); 
		query.append("CNTR_TPSZ_CD                ," ).append("\n"); 
		query.append("CNMV_YR                     ," ).append("\n"); 
		query.append("@[cop_sts_cd]  as COP_STS_CD                 ," ).append("\n"); 
		query.append("A.PCTL_NO                     ," ).append("\n"); 
		query.append("MST_COP_NO                  ," ).append("\n"); 
		query.append("TO_CHAR(COP_FSH_DT, 'YYYYMMDDHH24MISS') AS COP_FSH_DT  ," ).append("\n"); 
		query.append("A.TRNK_VSL_CD                 ," ).append("\n"); 
		query.append("A.TRNK_SKD_VOY_NO             ," ).append("\n"); 
		query.append("A.TRNK_SKD_DIR_CD             ," ).append("\n"); 
		query.append("A.POR_NOD_CD                  ," ).append("\n"); 
		query.append("A.POL_NOD_CD                  ," ).append("\n"); 
		query.append("A.POD_NOD_CD                  ," ).append("\n"); 
		query.append("A.DEL_NOD_CD                  ," ).append("\n"); 
		query.append("COP_RAIL_CHK_CD             ," ).append("\n"); 
		query.append("IB_TRO_FLG                  ," ).append("\n"); 
		query.append("OB_TRO_FLG                  ," ).append("\n"); 
		query.append("RAIL_RCV_COFF_DT_SRC_TP_CD  ," ).append("\n"); 
		query.append("TO_CHAR(RAIL_RCV_COFF_FM_DT, 'YYYYMMDDHH24MISS') AS RAIL_RCV_COFF_FM_DT         ," ).append("\n"); 
		query.append("A.CRE_USR_ID                  ," ).append("\n"); 
		query.append("TO_CHAR(A.CRE_DT, 'YYYYMMDDHH24MISS') AS CRE_DT                     ," ).append("\n"); 
		query.append("A.UPD_USR_ID                  ," ).append("\n"); 
		query.append("TO_CHAR(A.UPD_DT, 'YYYYMMDDHH24MISS') AS UPD_DT                     ," ).append("\n"); 
		query.append("COP_SUB_STS_CD              ," ).append("\n"); 
		query.append("TO_CHAR(RAIL_RCV_COFF_TO_DT, 'YYYYMMDDHH24MISS') AS RAIL_RCV_COFF_TO_DT       ," ).append("\n"); 
		query.append("UMCH_STS_CD                 ," ).append("\n"); 
		query.append("PROV_CNTR_NO                ," ).append("\n"); 
		query.append("PROV_CNTR_TPSZ_CD           ," ).append("\n"); 
		query.append("TO_CHAR(CFM_OB_DOR_ARR_DT, 'YYYYMMDDHH24MISS') AS CFM_OB_DOR_ARR_DT           ," ).append("\n"); 
		query.append("TO_CHAR(CFM_APNT_DT, 'YYYYMMDDHH24MISS') AS CFM_APNT_DT                ," ).append("\n"); 
		query.append("@[cop_upd_rmk] AS COP_UPD_RMK" ).append("\n"); 
		query.append("FROM SCE_COP_HDR A, BKG_BOOKING C, PRD_PROD_CTL_MST H" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND A.PCTL_NO = H.PCTL_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}