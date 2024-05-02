/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOModifyCFMDateVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.27
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.04.27 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOModifyCFMDateVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [경리환율 존재하는 경우] ERP I/F  처리
	  * [경리환율 존재하지 않는 경우] INV_AR_MN.BL_INV_CFM_DT 컬럼을 NULL 로 Update 하고 종료(No Good 처리한다는 의미)
	  * </pre>
	  */
	public BookingARCreationDBDAOModifyCFMDateVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOModifyCFMDateVOUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_MN SET " ).append("\n"); 
		query.append("#if (${flag} == 'good') " ).append("\n"); 
		query.append("BL_INV_CFM_DT = TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ar_ofc_cd]),'YYYYMMDD')" ).append("\n"); 
		query.append(", IF_SEQ = (SELECT NVL((SELECT MAX(IF_SEQ) FROM INV_AR_MN WHERE BL_SRC_NO = @[bl_src_no] ), 0) + 1 FROM DUAL)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("BL_INV_CFM_DT = null" ).append("\n"); 
		query.append(", IF_SEQ = null" ).append("\n"); 
		query.append(", GL_EFF_DT = null" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE AR_IF_NO = @[if_no]" ).append("\n"); 
		query.append("#if (${flag} == 'good')" ).append("\n"); 
		query.append("  AND BL_INV_CFM_DT IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}