/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementValidationDBDAOcheckBKGNoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier :
*@LastVersion : 1.0
* 2009.06.25
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyung Min Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementValidationDBDAOcheckBKGNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * BKGNO CHECK
	  * </pre>
	  */
	public ContainerMovementValidationDBDAOcheckBKGNoRSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT CNTR.BKG_NO," ).append("\n");
		query.append("BOOK.RCV_TERM_CD," ).append("\n");
		query.append("BOOK.POR_CD," ).append("\n");
		query.append("CNTR.DEST_YD_CD" ).append("\n");
		query.append("FROM   BKG_BOOKING BOOK, BKG_CONTAINER CNTR" ).append("\n");
		query.append("WHERE  1 = 1" ).append("\n");
		query.append("#if (${p_bkg_no} != '')" ).append("\n");
		query.append("AND    CNTR.CNTR_NO LIKE SUBSTR(@[p_bkg_no],0,10) || '_'" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("AND    BOOK.BKG_NO = CNTR.BKG_NO" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.integration").append("\n");
		query.append("FileName : ContainerMovementValidationDBDAOcheckBKGNoRSQL").append("\n");
		query.append("*/").append("\n");
	}
}