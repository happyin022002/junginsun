/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingARCreationDBDAOsearchOldCutOffLaneOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.12 
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

public class BookingARCreationDBDAOsearchOldCutOffLaneOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DBXXX Office의 경우 이전에 CutOff Lane에 등록되어 AR Office가 DOHBA로 결정되었으나, CutOff Lane이 삭제됨에 따라서 
	  * DOHBA가 아닌 DXBSC로 AR Office가 결정됨. 따라서 CutOff Lane이 삭제된 이후에는 DBXXX로 결정됨.
	  * 그러나 삭제 이전에 발생한 BL에 대해서 CA가 발생하면,  삭제이전의 AR Office를 따라야 하기때문에,
	  * DXBSC의 경우 최근 I/F 된 AR Office가DXBSC 인지 DOHBA 인지 Check가 필요함.
	  * 이 SQL은 최근 I/F 된 AR Office가 DXBSC 인지 DOHBA 인지 Check 하는 Query임.
	  * </pre>
	  */
	public BookingARCreationDBDAOsearchOldCutOffLaneOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOsearchOldCutOffLaneOfficeRSQL").append("\n"); 
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
		query.append("SELECT NVL(AR_OFC_CD, 'DXBSC') AR_OFC_CD" ).append("\n"); 
		query.append("FROM   INV_BKG_IF_CHG" ).append("\n"); 
		query.append("WHERE  (BKG_NO, BKG_SEQ) IN (" ).append("\n"); 
		query.append("							   SELECT BKG_NO, MAX(BKG_SEQ)" ).append("\n"); 
		query.append("							   FROM   INV_AR_MN" ).append("\n"); 
		query.append("							   WHERE  BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("							   GROUP BY BKG_NO" ).append("\n"); 
		query.append("							 )" ).append("\n"); 
		query.append("AND    OFC_CD = 'DXBSC'" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 

	}
}