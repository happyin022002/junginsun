/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchTiTrsmContentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.12
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.07.12 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchTiTrsmContentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, PTT(TI type) 전송 컨텐츠 조회
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchTiTrsmContentRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irs_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchTiTrsmContentRSQL").append("\n"); 
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
		query.append("(SELECT  NVL( MAX(  DECODE ( ATTR_CTNT2, 'ALL', ATTR_CTNT3, IT.CSTMS_POD_CD, ATTR_CTNT3  )   ) , '    ')" ).append("\n"); 
		query.append("FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID = 'SC_FIRMS_CD_MAP_PTT'" ).append("\n"); 
		query.append("AND ATTR_CTNT1 = BKG.SC_NO) T_FIRMS_CODE," ).append("\n"); 
		query.append("DECODE(	BKG.SC_NO, 'AEN18182', '62-086991500', 'AEN26200', '62-086991500', @[irs_no]) T_BOND_CARRIER" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_CSTMS_ADV_BL IT, BKG_BOOKING BKG" ).append("\n"); 
		query.append("WHERE IT.BKG_NO   = BKG.BKG_NO" ).append("\n"); 
		query.append("AND IT.CNT_CD   = 'US'" ).append("\n"); 
		query.append("AND IT.BL_NO    = @[bl_no]" ).append("\n"); 

	}
}