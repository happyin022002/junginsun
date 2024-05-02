/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchYardRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.06.29 김병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Byung Kyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchYardRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * RCV/DLV Term이 Yard 인데 POR/DEL에 속한 YARD가 없을 경우 확인
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchYardRSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT	count(1) CNT" ).append("\n");
		query.append("FROM	mdm_YARD" ).append("\n");
		query.append("WHERE	loc_cd   = @[loc_cd]" ).append("\n");
		query.append("#if (${yd_cd}!= '')" ).append("\n");
		query.append("AND     yd_cd = @[yd_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("AND		delt_flg = 'N'" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n");
		query.append("FileName : GeneralBookingReceiptDBDAOSearchYardRSQL").append("\n");
		query.append("*/").append("\n");
	}
}