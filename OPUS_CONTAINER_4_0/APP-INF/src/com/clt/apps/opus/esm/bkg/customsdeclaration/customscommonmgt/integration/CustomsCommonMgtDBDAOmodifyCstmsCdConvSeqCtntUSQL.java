/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustomsCommonMgtDBDAOmodifyCstmsCdConvSeqCtntUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2015.06.25 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomsCommonMgtDBDAOmodifyCstmsCdConvSeqCtntUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyCstmsCdConvCtnt
	  * </pre>
	  */
	public CustomsCommonMgtDBDAOmodifyCstmsCdConvSeqCtntUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_div_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_div_id_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.integration").append("\n"); 
		query.append("FileName : CustomsCommonMgtDBDAOmodifyCstmsCdConvSeqCtntUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("SET ATTR_CTNT1 = @[attr_ctnt1]," ).append("\n"); 
		query.append("	ATTR_CTNT2 = @[attr_ctnt2]," ).append("\n"); 
		query.append("	ATTR_CTNT3 = @[attr_ctnt3]," ).append("\n"); 
		query.append("	ATTR_CTNT4 = @[attr_ctnt4]," ).append("\n"); 
		query.append("	ATTR_CTNT5 = @[attr_ctnt5]," ).append("\n"); 
		query.append("	UPD_USR_ID = @[user_id]," ).append("\n"); 
		query.append("	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID = @[cstms_div_id]" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID_SEQ = @[cstms_div_id_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}