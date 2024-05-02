/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BrcsCustomsTransmissionDBDAOsearchMarkDescInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BrcsCustomsTransmissionDBDAOsearchMarkDescInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG의 Mark/Desc 정보를 조회한다.
	  * 2011.03.03 김영철 [CHM-201109060] Desc 값에 Tab, Enter 값을 공백으로 치완
	  * </pre>
	  */
	public BrcsCustomsTransmissionDBDAOsearchMarkDescInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.integration").append("\n"); 
		query.append("FileName : BrcsCustomsTransmissionDBDAOsearchMarkDescInfoRSQL").append("\n"); 
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
		query.append("SELECT REPLACE(REPLACE((NVL(PCK_CMDT_DESC, '') || CHR(10) || NVL(CNTR_CMDT_DESC, '') || CHR(10) ||  NVL(CMDT_DESC, '')),CHR(9),''),CHR(13),'') CMDT_DESC" ).append("\n"); 
		query.append(", REPLACE(REPLACE(NVL(MK_DESC, ' '),CHR(9),''),CHR(13),'') MK_MARK" ).append("\n"); 
		query.append("FROM BKG_BL_MK_DESC A, BKG_BL_DOC B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}