/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchBkgVvdRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.07.07 최영희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Yeoung Hee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchBkgVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * bkg_vvd에서 모든 항목을 조회함
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchBkgVvdRSQL(){
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
		query.append("select BKG_NO" ).append("\n");
		query.append(",VSL_PRE_PST_CD" ).append("\n");
		query.append(",VSL_SEQ" ).append("\n");
		query.append(",SLAN_CD" ).append("\n");
		query.append(",VSL_CD" ).append("\n");
		query.append(",SKD_VOY_NO" ).append("\n");
		query.append(",SKD_DIR_CD" ).append("\n");
		query.append(",POL_CLPT_IND_SEQ" ).append("\n");
		query.append(",OP_CD" ).append("\n");
		query.append(",POL_CD" ).append("\n");
		query.append(",POL_YD_CD" ).append("\n");
		query.append(",POD_CD" ).append("\n");
		query.append(",POD_YD_CD" ).append("\n");
		query.append(",BKG_TRSP_MZD_CD" ).append("\n");
		query.append(",CNTR_LODG_FLG" ).append("\n");
		query.append(",REV_VVD_FLG" ).append("\n");
		query.append(",CRE_USR_ID" ).append("\n");
		query.append(",CRE_DT" ).append("\n");
		query.append(",UPD_USR_ID" ).append("\n");
		query.append(",UPD_DT" ).append("\n");
		query.append(",POD_CLPT_IND_SEQ" ).append("\n");
		query.append("FROM BKG_VVD" ).append("\n");
		query.append("where bkg_no = @[bkg_no]" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n");
		query.append("FileName : GeneralBookingReceiptDBDAOSearchBkgVvdRSQL").append("\n");
		query.append("*/").append("\n");
	}
}