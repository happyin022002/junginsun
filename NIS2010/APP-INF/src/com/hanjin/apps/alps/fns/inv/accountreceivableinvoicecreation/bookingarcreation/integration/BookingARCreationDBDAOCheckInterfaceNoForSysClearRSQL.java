/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOCheckInterfaceNoForSysClearRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.04.14 최도순
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

public class BookingARCreationDBDAOCheckInterfaceNoForSysClearRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SYS CLEAR 대상 INTERFACE인지 확인한다.
	  * </pre>
	  */
	public BookingARCreationDBDAOCheckInterfaceNoForSysClearRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_no1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_no2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_no6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_no5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_no4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_no3",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOCheckInterfaceNoForSysClearRSQL").append("\n"); 
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
		query.append("SELECT  SUM(SUM_CHG_AMT) SUM_CHG_AMT" ).append("\n"); 
		query.append("        FROM  (        " ).append("\n"); 
		query.append("              SELECT /*+ ORDERED USE_NL(A B) INDEX(B XAK3INV_AR_CHG) */" ).append("\n"); 
		query.append("                     A.AR_OFC_CD, A.BL_SRC_NO, B.CURR_CD," ).append("\n"); 
		query.append("                     SUM(B.CHG_AMT) SUM_CHG_AMT" ).append("\n"); 
		query.append("                FROM INV_AR_MN A, INV_AR_CHG B" ).append("\n"); 
		query.append("               WHERE A.AR_IF_NO = B.AR_IF_NO " ).append("\n"); 
		query.append("                 AND A.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                 AND A.AR_IF_NO IN (@[if_no1],@[if_no2],@[if_no3],@[if_no4],@[if_no5],@[if_no6])" ).append("\n"); 
		query.append("                 AND A.INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("                 AND A.BL_INV_CFM_DT IS NOT NULL  " ).append("\n"); 
		query.append("                 AND NVL(A.INV_DELT_DIV_CD,'N') <> 'Y'   " ).append("\n"); 
		query.append("              GROUP BY A.AR_OFC_CD, A.BL_SRC_NO, B.CURR_CD" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("GROUP BY AR_OFC_CD, BL_SRC_NO" ).append("\n"); 

	}
}