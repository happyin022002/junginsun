/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchVslSkdInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchVslSkdInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchVslSkdInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchVslSkdInterfaceRSQL").append("\n"); 
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
		query.append("/*BKG이 ALPS에 생성된 상태일 때만 조회됨. */" ).append("\n"); 
		query.append("SELECT V.VSL_PRE_PST_CD," ).append("\n"); 
		query.append("       V.VSL_SEQ," ).append("\n"); 
		query.append("       V.POL_CD," ).append("\n"); 
		query.append("       SUBSTR(V.POL_YD_CD,6,2) POL_YD_CD," ).append("\n"); 
		query.append("       V.POD_CD," ).append("\n"); 
		query.append("       SUBSTR(V.POD_YD_CD,6,2) POD_YD_CD," ).append("\n"); 
		query.append("       V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD BKG_VVD_CD," ).append("\n"); 
		query.append("       V.POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("       V.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST M, BKG_VVD V" ).append("\n"); 
		query.append("WHERE M.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("AND M.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND M.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND M.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 

	}
}