/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsCustomsTransmissionDBDAOsearchAncsCstmsSndHisListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.08.13 정재엽
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.interation;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Jae Yoeb
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsCustomsTransmissionDBDAOsearchAncsCstmsSndHisListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SELECT
	  * </pre>
	  */
	public AncsCustomsTransmissionDBDAOsearchAncsCstmsSndHisListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.interation").append("\n"); 
		query.append("FileName : AncsCustomsTransmissionDBDAOsearchAncsCstmsSndHisListRSQL").append("\n"); 
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
		query.append("VVD_NM" ).append("\n"); 
		query.append(",VVD.SVC_RQST_NO" ).append("\n"); 
		query.append(",HIS.EDI_SND_STS_CD" ).append("\n"); 
		query.append(",HIS.EDI_RCV_STS_CD" ).append("\n"); 
		query.append(",HIS.SND_DT" ).append("\n"); 
		query.append(",HIS.RCV_DT" ).append("\n"); 
		query.append(",HIS.EDI_SND_USR_ID" ).append("\n"); 
		query.append(",HIS.SND_OFC_CD" ).append("\n"); 
		query.append(",HIS.VSL_CD || HIS.SKD_VOY_NO || HIS.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append(",HIS.ANR_DECL_NO" ).append("\n"); 
		query.append(",HIS.REF_SEQ" ).append("\n"); 
		query.append(",HIS.EDI_MSG_ERR_ID" ).append("\n"); 
		query.append(",HIS.ERR_DESC AS ERR" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_VVD VVD, BKG_CSTMS_ANR_EDI_HIS HIS" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND MSG_TP_CD = 'R'" ).append("\n"); 
		query.append("AND VVD.VSL_CD        =  SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO    =  SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD    =  SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("AND (VVD.SVC_RQST_NO || VVD.LLOYD_TP_CD || VVD.LLOYD_NO) = HIS.ANR_DECL_NO" ).append("\n"); 

	}
}