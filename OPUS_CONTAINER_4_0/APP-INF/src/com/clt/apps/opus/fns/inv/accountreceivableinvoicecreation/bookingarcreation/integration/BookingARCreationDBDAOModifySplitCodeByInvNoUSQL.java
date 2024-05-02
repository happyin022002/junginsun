/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOModifySplitCodeByInvNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.14
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.07.14 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOModifySplitCodeByInvNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INV_AR_MN 테이블에 Update
	  * 
	  * Master가 되는 대상  데이터에 Split ind를 'M'으로 update  함.
	  * </pre>
	  */
	public BookingARCreationDBDAOModifySplitCodeByInvNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_split_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOModifySplitCodeByInvNoUSQL").append("\n"); 
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
		query.append("   SET INV_SPLIT_CD = @[inv_split_cd]," ).append("\n"); 
		query.append("       UPD_USR_ID	= @[upd_usr_id]," ).append("\n"); 
		query.append("	   UPD_DT       = SYSDATE" ).append("\n"); 
		query.append(" WHERE NVL(INV_SPLIT_CD,'M') NOT IN ('S','C','E','X')" ).append("\n"); 
		query.append("   AND AR_IF_NO IN (SELECT DISTINCT MN.AR_IF_NO" ).append("\n"); 
		query.append("					  FROM INV_AR_ISS_DTL DTL," ).append("\n"); 
		query.append("						   INV_AR_CHG     CHG," ).append("\n"); 
		query.append("						   INV_AR_MN      MN" ).append("\n"); 
		query.append("					 WHERE DTL.AR_IF_NO = CHG.AR_IF_NO" ).append("\n"); 
		query.append("					   AND DTL.CHG_SEQ      = CHG.CHG_SEQ" ).append("\n"); 
		query.append("					   AND CHG.AR_IF_NO     = MN.AR_IF_NO" ).append("\n"); 
		query.append("					   AND MN.AR_OFC_CD       = @[ofc_cd]" ).append("\n"); 
		query.append("					   AND DTL.INV_NO         = @[inv_no]" ).append("\n"); 
		query.append("					   --AND MN.REV_TP_CD <> 'M' 2009-12-02 김현화 수석" ).append("\n"); 
		query.append("					   AND NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("					   AND NVL(MN.INV_SPLIT_CD,'N') NOT IN ('M','X'))" ).append("\n"); 

	}
}