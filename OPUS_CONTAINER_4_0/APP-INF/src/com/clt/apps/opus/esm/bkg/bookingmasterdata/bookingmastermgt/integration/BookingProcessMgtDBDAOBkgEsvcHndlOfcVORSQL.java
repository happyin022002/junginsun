/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingProcessMgtDBDAOBkgEsvcHndlOfcVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.10.13 강동윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kang dong yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingProcessMgtDBDAOBkgEsvcHndlOfcVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public BookingProcessMgtDBDAOBkgEsvcHndlOfcVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingProcessMgtDBDAOBkgEsvcHndlOfcVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.HNDL_OFC_CD" ).append("\n"); 
		query.append(",   A.GSO_OFC_CD" ).append("\n"); 
		query.append(",   A.RGN_OFC_CD" ).append("\n"); 
		query.append(",   BKG_JOIN_FNC(CURSOR(SELECT CTRL_OFC_CD  FROM BKG_ESVC_CTRL_OFC WHERE HNDL_OFC_CD = A.HNDL_OFC_CD)) AS CTRL_OFC_CD" ).append("\n"); 
		query.append(",   BKG_JOIN_FNC(CURSOR(SELECT SI_NTFC_EML  FROM BKG_ESVC_OFC_EML  WHERE HNDL_OFC_CD = A.HNDL_OFC_CD)) AS SI_NTFC_EML" ).append("\n"); 
		query.append(",   BKG_JOIN_FNC(CURSOR(SELECT BKG_NTFC_EML FROM BKG_ESVC_OFC_EML  WHERE HNDL_OFC_CD = A.HNDL_OFC_CD)) AS BKG_NTFC_EML" ).append("\n"); 
		query.append("FROM BKG_ESVC_HNDL_OFC A" ).append("\n"); 
		query.append("#if (${chk_op} == '3' && ${ofc_cd} != '')" ).append("\n"); 
		query.append(",BKG_ESVC_CTRL_OFC B" ).append("\n"); 
		query.append("WHERE   A.HNDL_OFC_CD = B.HNDL_OFC_CD" ).append("\n"); 
		query.append("AND	B.CTRL_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#elseif (${chk_op} == '0' && ${ofc_cd} != '')" ).append("\n"); 
		query.append("WHERE	A.HNDL_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#elseif (${chk_op} != '1' && ${ofc_cd} != '')" ).append("\n"); 
		query.append("WHERE	A.RGN_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#elseif (${chk_op} != '2' && ${ofc_cd} != '')" ).append("\n"); 
		query.append("WHERE	A.GSO_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}