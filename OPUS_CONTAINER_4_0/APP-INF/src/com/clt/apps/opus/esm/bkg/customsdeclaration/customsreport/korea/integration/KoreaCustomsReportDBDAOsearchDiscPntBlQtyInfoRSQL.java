/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KoreaCustomsReportDBDAOsearchDiscPntBlQtyInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.09.25 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KoreaCustomsReportDBDAOsearchDiscPntBlQtyInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 하선신고서 Print form내역중 BL 및 Weight, Package정보 조회
	  * </pre>
	  */
	public KoreaCustomsReportDBDAOsearchDiscPntBlQtyInfoRSQL(){
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

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration ").append("\n");
		query.append("FileName : KoreaCustomsReportDBDAOsearchDiscPntBlQtyInfoRSQL").append("\n");
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
		query.append("SELECT DECODE(NVL(A.BL_NO,' '),' ',COM_ConstantMgr_PKG.COM_getScacCode_FNC()||NVL(A.BKG_NO,' '), COM_ConstantMgr_PKG.COM_getScacCode_FNC()||NVL(A.BL_NO,' ')) BL_NO" ).append("\n");
		query.append(", DECODE(B.ACT_WGT,0,' ',TO_CHAR(DECODE(NVL(B.WGT_UT_CD,' '),'LBS',(B.ACT_WGT*0.4536),B.ACT_WGT),'999999999')) ACT_WGT" ).append("\n");
		query.append(", DECODE(B.PCK_QTY,0,' ',TO_CHAR(B.PCK_QTY,'9999999')) PCK_QTY" ).append("\n");
		query.append(", DECODE(B.PCK_QTY,0,' ',NVL(B.PCK_TP_CD,' ')) PCK_TP_CD" ).append("\n");
		query.append("FROM BKG_BOOKING A, BKG_BL_DOC B" ).append("\n");
		query.append("WHERE A.BKG_NO = B.BKG_NO" ).append("\n");
		query.append("AND A.BKG_NO = @[bkg_no]" ).append("\n");

	}
}