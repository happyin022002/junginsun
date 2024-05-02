/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AncsCustomsTransmissionDBDAOmodifyCntrAnrMsgStsCdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.05
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.10.05 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.interation;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsCustomsTransmissionDBDAOmodifyCntrAnrMsgStsCdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * U
	  * </pre>
	  */
	public AncsCustomsTransmissionDBDAOmodifyCntrAnrMsgStsCdUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.interation").append("\n"); 
		query.append("FileName : AncsCustomsTransmissionDBDAOmodifyCntrAnrMsgStsCdUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_ANR_CNTR" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("ANR_MSG_STS_CD = null" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#if (${cntr_chk} != '')" ).append("\n"); 
		query.append("   AND CNTR_NO IN (" ).append("\n"); 
		query.append("#foreach($cntrNo IN ${cntr_no})  " ).append("\n"); 
		query.append("'$cntrNo',  " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("'')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}