/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOInvIssContainerCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2010.01.07 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Han Dong Hoon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOInvIssContainerCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvIssContainer
	  * </pre>
	  */
	public BookingARCreationDBDAOInvIssContainerCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrk_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOInvIssContainerCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_AR_CNTR" ).append("\n"); 
		query.append("(AR_IF_NO, CNTR_SEQ, CNTR_NO, CNTR_TPSZ_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT B.AR_IF_NO" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER (PARTITION BY B.AR_IF_NO ORDER BY B.AR_IF_NO,C.CNTR_NO)" ).append("\n"); 
		query.append(",C.CNTR_NO,C.CNTR_TPSZ_CD,@[user_id],SYSDATE,@[user_id],SYSDATE" ).append("\n"); 
		query.append("FROM INV_AR_MN B" ).append("\n"); 
		query.append(",BKG_CONTAINER C" ).append("\n"); 
		query.append("WHERE B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND B.AR_IF_NO IN (SELECT V1.AR_IF_NO" ).append("\n"); 
		query.append("FROM INV_AR_ISS_FTR V1" ).append("\n"); 
		query.append("WHERE INV_ISS_WRK_NO = @[wrk_no]" ).append("\n"); 
		query.append("GROUP BY V1.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(", V1.ACT_CUST_SEQ" ).append("\n"); 
		query.append(", V1.VSL_CD" ).append("\n"); 
		query.append(", V1.SKD_VOY_NO" ).append("\n"); 
		query.append(", V1.SKD_DIR_CD" ).append("\n"); 
		query.append(", V1.IO_BND_CD" ).append("\n"); 
		query.append(", V1.PORT_CD" ).append("\n"); 
		query.append(", V1.SVC_SCP_CD" ).append("\n"); 
		query.append("#if (${inv_mlt_bl_iss_flg} != 'Y')" ).append("\n"); 
		query.append(", V1.BL_SRC_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", V1.INV_ISS_TP_CD" ).append("\n"); 
		query.append(", V1.INV_SPLIT_CD" ).append("\n"); 
		query.append(", V1.USD_XCH_RT" ).append("\n"); 
		query.append(", V1.AR_OFC_CD" ).append("\n"); 
		query.append(", V1.AR_IF_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}