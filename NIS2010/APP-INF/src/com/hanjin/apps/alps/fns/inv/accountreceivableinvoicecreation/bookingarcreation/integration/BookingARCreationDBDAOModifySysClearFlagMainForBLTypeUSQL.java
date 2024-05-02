/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : BookingARCreationDBDAOModifySysClearFlagMainForBLTypeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.28
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOModifySysClearFlagMainForBLTypeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OTS_SMRY_CD = 'BL' 인 OFC 에 한해서
	  * 기존 MAX(I/F NO) 의 INV_AR_MN 의 환율이 0 인데 CANCEL 되는거라면
	  * 무조건 SYS CLEAR 처리를 한다
	  * - MAIN
	  * 2011.11.24 환율이 0 인 것만 대상으로 하던것 삭제
	  * 처음엔 환율이 0 이어서 SYS CLEAR 처리가 되었으나 이후 환율 일괄 업데이트를 하면서 환율이 생성되다보니 
	  * 중간 중간 SYS CLEAR 된것이 있어서 오히려 혼동이 되어 김희경 과장님과 확인하고 환율이 0 인것만을 SYS CLEAR 처리하던것을 삭제하기로 함
	  * </pre>
	  */
	public BookingARCreationDBDAOModifySysClearFlagMainForBLTypeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cancel_if_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("max_if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOModifySysClearFlagMainForBLTypeUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_MN" ).append("\n"); 
		query.append("   SET INV_ISS_FLG = 'Y'," ).append("\n"); 
		query.append("       INV_CLR_FLG = 'Y'," ).append("\n"); 
		query.append("       ISS_DT = TO_CHAR( SYSDATE, 'YYYYMMDD' )," ).append("\n"); 
		query.append("       UPD_USR_ID  = @[upd_usr_id]," ).append("\n"); 
		query.append("       UPD_DT      = SYSDATE" ).append("\n"); 
		query.append(" WHERE AR_IF_NO IN (@[max_if_no],@[cancel_if_no])" ).append("\n"); 
		query.append("   AND INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("   AND INV_CLR_FLG = 'N'" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 1" ).append("\n"); 
		query.append("                 FROM INV_AR_MN " ).append("\n"); 
		query.append("                WHERE AR_IF_NO = @[max_if_no]" ).append("\n"); 
		query.append("                  AND BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                  AND INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("				  AND NVL(IDA_INV_SPLIT_FLG, 'N') = 'N'			-- 2018.05.28 인도지역 Split Invoice Issue 기능 보완 " ).append("\n"); 
		query.append("			      AND ACT_CUST_CNT_CD = (SELECT ACT_CUST_CNT_CD FROM INV_AR_MN WHERE AR_IF_NO = @[cancel_if_no])" ).append("\n"); 
		query.append("                  AND ACT_CUST_SEQ = (SELECT ACT_CUST_SEQ FROM INV_AR_MN WHERE AR_IF_NO = @[cancel_if_no])" ).append("\n"); 
		query.append("                  AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("                  AND AR_OFC_CD IN (SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                                        FROM INV_AR_STUP_OFC" ).append("\n"); 
		query.append("                                       WHERE AR_OFC_CD = (SELECT AR_OFC_CD FROM INV_AR_MN WHERE AR_IF_NO = @[max_if_no])" ).append("\n"); 
		query.append("                                         AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                         AND OTS_SMRY_CD = 'BL'))    ----- BL TYPE 인 것만 대상으로 함 (예: BOMSC, CMBSC)" ).append("\n"); 

	}
}