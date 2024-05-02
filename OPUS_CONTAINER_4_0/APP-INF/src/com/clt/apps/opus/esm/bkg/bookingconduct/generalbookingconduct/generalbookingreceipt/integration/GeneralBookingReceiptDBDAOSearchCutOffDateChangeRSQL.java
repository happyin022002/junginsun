/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchCutOffDateChangeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.03
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2015.12.03 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchCutOffDateChangeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Query to check whether cut-off date is updated or not
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchCutOffDateChangeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cut_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("clz_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchCutOffDateChangeRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("        CASE WHEN CLZ_TP_CD = 'R' THEN 'CTIN'" ).append("\n"); 
		query.append("             WHEN CLZ_TP_CD = 'T' THEN 'CTPO'" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("        END AS TRO_CD" ).append("\n"); 
		query.append("FROM    BKG_CLZ_TM" ).append("\n"); 
		query.append("WHERE   0=0" ).append("\n"); 
		query.append("AND     BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND     CLZ_TP_CD = @[clz_tp_cd]" ).append("\n"); 
		query.append("AND     NVL(MNL_SET_DT, SYS_SET_DT) <> TO_DATE(@[cut_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 

	}
}